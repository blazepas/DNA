package pl.blazej.szczypka;

import static pl.blazej.szczypka.ReadData.initialiseApp;

/*
DNA version 2 (after refactoring)
Check if both DNA chains are compliance in structure.
Compliance it means that second chain could be created from first one (and reverse: first created from second).
Character occurances in DNA must be exactly the same in both chains.
*/

public class DNA {
    public static void main(String[] args) {
        initialiseApp();
    }
}