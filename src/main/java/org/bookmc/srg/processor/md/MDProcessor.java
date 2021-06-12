package org.bookmc.srg.processor.md;

import org.bookmc.srg.output.SrgOutputDirty;
import org.bookmc.srg.output.MappedMethod;
import org.bookmc.srg.processor.RawMappingProcessor;

public class MDProcessor implements RawMappingProcessor {
    @Override
    public boolean detect(String line) {
        return line.startsWith("MD: ");
    }

    @Override
    public void process(SrgOutputDirty output, String line) {
        // ID          OWNER WITH METHOD NAME                                             MAPPED DESC          UNMAPPED NAME             UNMAPPED DESC
        // MD: net/minecraft/util/EnumChatFormatting/getTextWithoutFormattingCodes (Ljava/lang/String;)Ljava/lang/String; a/a (Ljava/lang/String;)Ljava/lang/String;

        String[] items = line.replace("MD: ", "").split(" ");

        String mappedOwnerWithName = items[0];

        String mappedName = mappedOwnerWithName.substring(mappedOwnerWithName.lastIndexOf("/") + 1);
        String mappedOwner = mappedOwnerWithName.replace("/" + mappedName, "");
        String mappedDesc = items[1];

        String unmappedOwnerWithName = items[2];

        String unmappedName = unmappedOwnerWithName.substring(unmappedOwnerWithName.lastIndexOf("/") + 1);
        String unmappedOwner = unmappedOwnerWithName.replace("/" + unmappedName, "");
        String unmappedDesc = items[3];

        output.addMethod(new MappedMethod(unmappedOwner, mappedOwner, unmappedName, mappedName, unmappedDesc, mappedDesc));
    }
}
