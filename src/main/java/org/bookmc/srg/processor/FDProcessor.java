package org.bookmc.srg.processor;

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

        String obfuscatedOwnerAndField = split[0];
        String obfuscatedName = obfuscatedOwnerAndField.substring(obfuscatedOwnerAndField.lastIndexOf("/") + 1);
        String obfuscatedOwner = obfuscatedOwnerAndField.replace("/" + obfuscatedName, "");

        String deobfuscatedOwnerAndField = split[1];

        String deobfuscatedName = deobfuscatedOwnerAndField.substring(deobfuscatedOwnerAndField.lastIndexOf("/") + 1);
        String deobfuscatedOwner = deobfuscatedOwnerAndField.replace("/" + deobfuscatedName, "");

        output.addField(new MappedField(obfuscatedOwner, deobfuscatedOwner, obfuscatedName, deobfuscatedName));
    }
}
