package com.stochastictinkr.visualizer;

import lombok.NonNull;

public abstract class Algorithm {
    private final String name;
    private final BigO bigO;

    public Algorithm(@NonNull BigO bigO, @NonNull String sortName) {
        this.bigO = bigO;
        this.name = sortName;
    }

    public @NonNull String getName() {
        return name;
    }

    public @NonNull BigO getBigO() {
        return bigO;
    }

    public abstract void run(@NonNull SortState state);
}
