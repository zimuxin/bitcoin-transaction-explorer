package com.yoghurt.crypto.transactions.shared.util.transaction;

import com.yoghurt.crypto.transactions.shared.domain.RawTransactionContainer;
import com.yoghurt.crypto.transactions.shared.domain.ScriptEntity;
import com.yoghurt.crypto.transactions.shared.domain.ScriptPart;
import com.yoghurt.crypto.transactions.shared.domain.ScriptPartType;
import com.yoghurt.crypto.transactions.shared.domain.ScriptType;
import com.yoghurt.crypto.transactions.shared.domain.TransactionPartType;

public final class ScriptEncodeUtil {
  private ScriptEncodeUtil() {}

  public static byte[] encodeScript(final ScriptEntity script) {
    final int scriptSize = (int)script.getScriptSize().getValue();
    final byte[] bytes = new byte[scriptSize];

    int pointer = 0;
    for (final ScriptPart part : script.getInstructions()) {
      final byte[] partBytes = part.getBytes();

      if (part.getOperation() == null) {
        System.arraycopy(partBytes, 0, bytes, pointer, partBytes.length);
        pointer += partBytes.length;
      } else {
        System.arraycopy(new byte[] { ScriptOperationUtil.getOperationOpCode(part) }, 0, bytes, pointer, 1);
        pointer++;
        if (ScriptOperationUtil.isDataPushOperation(part.getOperation())) {
          System.arraycopy(partBytes, 0, bytes, pointer, partBytes.length);
        }
      }

    }

    return bytes;
  }

  public static void encodeScript(final ScriptEntity script, final RawTransactionContainer container, final ScriptType type) {
    for (final ScriptPart part : script.getInstructions()) {
      final TransactionPartType partType = ScriptOperationUtil.getScriptPartType(type, ScriptPartType.OP_CODE);

      if (part.getOperation() == null) {
        container.add(TransactionPartType.ARBITRARY_DATA, part.getBytes());
      } else {
        container.add(partType, new byte[] { ScriptOperationUtil.getOperationOpCode(part) });

        if (ScriptOperationUtil.isDataPushOperation(part.getOperation())) {
          final TransactionPartType pushPartType = ScriptOperationUtil.getScriptPartType(type, ScriptPartType.PUSH_DATA);
          container.add(pushPartType, part.getBytes());
        }
      }
    }
  }
}
