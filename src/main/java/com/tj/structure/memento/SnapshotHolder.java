package com.tj.structure.memento;

import java.util.Stack;

public class SnapshotHolder {
    private Stack<Snapshot> snapshots = new Stack<>();

    public Snapshot popSnapshot() {
        return snapshots.pop();
    }
    public void pushSnapshot(Snapshot snapshot) {
        snapshots.push(snapshot);
    }

    @Override
    public String toString() {
        return "SnapshotHolder{" +
                "snapshots=" + snapshots +
                '}';
    }
}