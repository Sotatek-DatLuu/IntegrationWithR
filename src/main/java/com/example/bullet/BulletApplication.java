package com.example.bullet;

import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;

public class BulletApplication {

    public static void main(String[] args) throws REngineException, REXPMismatchException {
        // path to folder contains x3p file or list link download x3p file
        String pathToFolderX3p = "README_files/data/Bullet2";
        double[] signature = RUtils.generateSignature(pathToFolderX3p);
        for (double d : signature) {
            System.err.print(d + ",");
        }
    }

}
