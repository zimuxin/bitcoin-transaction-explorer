package com.yoghurt.crypto.transactions.shared.domain;

import java.util.ArrayList;

public class Transaction {
  private byte[] txId;

  private int version;
  private int lockTime;

  private VariableLengthInteger inputSize;
  private ArrayList<TransactionInput> inputs;

  private VariableLengthInteger outputSize;
  private ArrayList<TransactionOutput> outputs;

  public byte[] getTransactionId() {
    return txId;
  }

  public void setTransactionId(final byte[] txId) {
    this.txId = txId;
  }

  public int getVersion() {
    return version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

  public VariableLengthInteger getInputSize() {
    return inputSize;
  }

  public void setInputSize(final VariableLengthInteger inputSize) {
    this.inputSize = inputSize;
  }

  public ArrayList<TransactionInput> getInputs() {
    return inputs;
  }

  public void setInputs(final ArrayList<TransactionInput> inputs) {
    this.inputs = inputs;
  }

  public VariableLengthInteger getOutputSize() {
    return outputSize;
  }

  public void setOutputSize(final VariableLengthInteger outputSize) {
    this.outputSize = outputSize;
  }

  public ArrayList<TransactionOutput> getOutputs() {
    return outputs;
  }

  public void setOutputs(final ArrayList<TransactionOutput> outputs) {
    this.outputs = outputs;
  }

  public int getLockTime() {
    return lockTime;
  }

  public void setLockTime(final int lockTime) {
    this.lockTime = lockTime;
  }

  public boolean isCoinbase() {
    return !inputs.isEmpty() && inputs.get(0).isCoinbase();
  }
}