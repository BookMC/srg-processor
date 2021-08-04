package org.bookmc.srg.processor;

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

        String obfuscatedOwnerWithName = items[0];

        String obfuscatedName = obfuscatedOwnerWithName.substring(obfuscatedOwnerWithName.lastIndexOf("/") + 1);
        String obfuscatedOwner = obfuscatedOwnerWithName.replace("/" + obfuscatedName, "");
        String obfuscatedDesc = items[1];

        String deobfuscatedOwnerWithName = items[2];

        String deobfuscatedName = deobfuscatedOwnerWithName.substring(deobfuscatedOwnerWithName.lastIndexOf("/") + 1);
        String deobfuscatedOwner = deobfuscatedOwnerWithName.replace("/" + deobfuscatedName, "");
        String deobfuscatedDesc = items[3];

        output.addMethod(new MappedMethod(obfuscatedOwner, deobfuscatedOwner, obfuscatedName, deobfuscatedName, obfuscatedDesc, deobfuscatedDesc));
    }
}
