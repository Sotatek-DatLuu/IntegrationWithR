package com.example.bullet;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPDouble;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RUtils {
    public static double[] generateSignature(String path) throws RserveException, REXPMismatchException {
        RConnection c = new RConnection("127.0.0.1", 6311);
        c.eval("library('dplyr')");
        c.eval("library('bulletxtrctr')");
        c.eval("library('x3ptools')");
        c.eval("library('randomForest')");
        c.eval("library('ggplot2')");
        c.eval("library('readr')");
        c.eval("library('nbtrd')");
        c.assign("path", path);
        REXP x = c.eval("try({gen_signature_from_x3p(path)}, silent=TRUE)");
        if (x.inherits("try-error")) {
            System.err.println("R Serve Eval Exception : " + x.asString());
        }
        REXPDouble signature = (REXPDouble) x.asList().get("sig");
        return signature.asDoubles();
    }

}
