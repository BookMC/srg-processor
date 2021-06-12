package org.bookmc.srg.processor;

import org.bookmc.srg.output.SrgOutputDirty;

public interface RawMappingProcessor {
   boolean detect(String line);

   void process(SrgOutputDirty output, String line);
}
