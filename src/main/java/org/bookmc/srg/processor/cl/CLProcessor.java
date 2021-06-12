package org.bookmc.srg.processor.cl;

import org.bookmc.srg.output.SrgOutputDirty;
import org.bookmc.srg.output.MappedClass;
import org.bookmc.srg.processor.RawMappingProcessor;

public class CLProcessor implements RawMappingProcessor {
    @Override
    public boolean detect(String line) {
        return line.startsWith("CL: ");
    }

    @Override
    public void process(SrgOutputDirty output, String line) {
        String[] items = line.replace("CL: ", "").split(" ");

        output.addClass(new MappedClass(items[0], items[1]));
    }
}
