package com.Threading;

import java.io.File;

public class CleaningScheduler implements Runnable {


    @Override
    public void run() {
        File folder = new File("Recycle Bin");
        File[] files = folder.listFiles();

        assert files != null;
        {
            for (File file : files) {
                file.delete();
            }
        }
    }
}
