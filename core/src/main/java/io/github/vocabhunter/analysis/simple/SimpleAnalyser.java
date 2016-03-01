/*
 * Open Source Software published under the Apache Licence, Version 2.0.
 */

package io.github.vocabhunter.analysis.simple;

import io.github.vocabhunter.analysis.model.Analyser;
import io.github.vocabhunter.analysis.model.AnalysisResult;
import io.github.vocabhunter.analysis.model.WordUse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class SimpleAnalyser implements Analyser {
    private static final Logger LOG = LoggerFactory.getLogger(SimpleAnalyser.class);

    @Override
    public AnalysisResult analyse(final Stream<String> lines, final String name) {
        Map<String, WordUse> map = lines.flatMap(l -> uses(l))
                .collect(
                        groupingBy(
                                WordUse::getWordIdentifier,
                                collectingAndThen(reducing(this::combine), Optional::get)));
        List<WordUse> uses = map.values().stream()
                .sorted(WordStreamTool.WORD_COMPARATOR)
                .collect(toList());
        AnalysisResult result = new AnalysisResult(name, uses);

        LOG.info("Analysed text and found {} words", uses.size());

        return result;
    }

    private Stream<WordUse> uses(final String line) {
        Map<String, Long> counts = WordStreamTool.words(line)
                .map(String::toLowerCase)
                .collect(
                        groupingBy(Function.identity(), counting()));

        return counts.entrySet().stream()
                .map(e -> new WordUse(e.getKey(), e.getValue().intValue(), line));
    }

    private WordUse combine(final WordUse w1, final WordUse w2) {
        List<String> l = new ArrayList<>(w1.getUses());

        l.addAll(w2.getUses());

        return new WordUse(w1.getWordIdentifier(), w1.getUseCount() + w2.getUseCount(), l);
    }
}
