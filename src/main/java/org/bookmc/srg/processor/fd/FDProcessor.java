package org.bookmc.srg.processor.fd;

import org.bookmc.srg.output.SrgOutputDirty;
import org.bookmc.srg.output.MappedField;
import org.bookmc.srg.processor.RawMappingProcessor;

public class FDProcessor implements RawMappingProcessor {
    @Override
    public boolean detect(String line) {
        return line.startsWith("FD:");
    }

    @Override
    public void process(SrgOutputDirty output, String line) {
        String[] split = line.replace("FD: ", "").split(" ");

        String mappedOwnerAndField = split[0];
        String mappedName = mappedOwnerAndField.substring(mappedOwnerAndField.lastIndexOf("/") + 1);
        String mappedOwner = mappedOwnerAndField.replace("/" + mappedName, "");

        String unmappedOwnerAndField = split[1];

        String unmappedName = unmappedOwnerAndField.substring(unmappedOwnerAndField.lastIndexOf("/") + 1);
        String unmappedOwner = unmappedOwnerAndField.replace("/" + unmappedName, "");

        output.addField(new MappedField(unmappedOwner, mappedOwner, unmappedName, mappedName));
    }
}
