package org.john.util;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author johnathon
 */
@Data
@NoArgsConstructor
public class BinaryTree {
    private BinaryTree leftChild;
    private BinaryTree rightChild;
    private Long value;

    public BinaryTree(Long value) {
        this.value = value;
    }
}
