package com.yoghurt.crypto.transactions.client.util;

import com.yoghurt.crypto.transactions.client.util.misc.Color;
import com.yoghurt.crypto.transactions.client.util.misc.ColorBuilder;
import com.yoghurt.crypto.transactions.shared.domain.TransactionPartType;

/**
 * TODO Move to proper package.
 */
public class TransactionPartColorPicker {
  public static Color getFieldColor(final TransactionPartType value) {
    final Color color;

    switch (value) {
    case TRANSACTION_HASH:
      color = ColorBuilder.interpret("cornflowerblue");
      break;
    case INPUT_OUTPOINT_INDEX:
      color = ColorBuilder.interpret("lightblue");
      break;
    case OUTPUT_SCRIPT_LENGTH:
    case INPUT_SCRIPT_LENGTH:
      color = ColorBuilder.interpret("mediumvioletred");
      break;
    case INPUT_SEQUENCE:
      color = ColorBuilder.interpret("lightgreen");
      break;
    case INPUT_SIZE:
    case OUTPUT_SIZE:
      color = ColorBuilder.interpret("pink");
      break;
    case OUTPUT_VALUE:
      color = ColorBuilder.interpret("gold");
      break;
    case SCRIPT_SIG_OP_CODE:
    case SCRIPT_PUB_KEY_OP_CODE:
      color = ColorBuilder.interpret("red");
      break;
    case SCRIPT_SIG_PUSH_DATA:
      color = ColorBuilder.interpret("cyan");
      break;
    case SCRIPT_PUB_KEY_PUSH_DATA:
      color = ColorBuilder.interpret("green");
      break;
    case ARBITRARY_DATA:
      color = ColorBuilder.interpret("black");
      break;
    case LOCK_TIME:
    case VERSION:
    default:
      color = ColorBuilder.interpret("grey");
      break;
    }

    return color;
  }
}