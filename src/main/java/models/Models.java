package models;

import lombok.Value;

import java.util.List;

public enum Models {
    ;
    @Value public static class Node { int val; List<Node> children; }
}
