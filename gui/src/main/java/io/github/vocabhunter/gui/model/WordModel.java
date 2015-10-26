/*
 * Open Source Software published under the Apache Licence, Version 2.0.
 */

package io.github.vocabhunter.gui.model;

import io.github.vocabhunter.analysis.session.WordState;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.util.Callback;

import java.util.Collections;
import java.util.List;

public class WordModel {
    public static final Callback<WordModel, Observable[]> PROPERTY_EXTRACTOR
            = w -> new Observable[] {w.identifier, w.state};

    private final int sequenceNo;

    private final List<String> uses;

    private final SimpleStringProperty identifier;

    private final SimpleObjectProperty<WordState> state;

    public WordModel(final int sequenceNo, final String word, final List<String> uses, final WordState state) {
        this.uses = uses;
        this.identifier = new SimpleStringProperty(word);
        this.sequenceNo = sequenceNo;
        this.state = new SimpleObjectProperty<>(state);
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public String getIdentifier() {
        return identifier.get();
    }

    public WordState getState() {
        return state.get();
    }

    public void setState(final WordState state) {
        this.state.set(state);
    }

    public SimpleObjectProperty<WordState> stateProperty() {
        return state;
    }

    public List<String> getUses() {
        return Collections.unmodifiableList(uses);
    }
}
