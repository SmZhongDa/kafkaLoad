package com.fiberhome.kafka.bcpparse;


import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.Serializable;
import org.apache.hadoop.io.Writable;

public final class lineParse implements Writable, Serializable
{
  private int columnCount;
  private int[] columnPosition;
  private char seperator;
  private String data;
  private boolean flexible = false;

  private int maxColumCount = -1;

  public lineParse()
  {
  }

  public lineParse(char seperator)
  {
    this.maxColumCount = 256;

    this.columnPosition = new int[this.maxColumCount + 1];
    this.seperator = seperator;

    this.flexible = true;
  }

  public lineParse(int columnCount, char seperator)
  {
    if (columnCount <= 0)
    {
      throw new IllegalArgumentException("columnCount is invalid");
    }

    this.maxColumCount = columnCount;

    this.columnPosition = new int[this.maxColumCount + 1];
    this.seperator = seperator;
  }

  public int getColumnCount()
  {
    return this.columnCount;
  }

  public char getSeperator() {
    return this.seperator;
  }

  public void parse(String line)
  {
    if (line == null)
    {
      throw new IllegalArgumentException("line is null");
    }

    this.data = line;

    int currentColumnCount = 0;
    this.columnPosition[currentColumnCount] = 0;

    int length = line.length();
    for (int i = 0; i < length; i++)
    {
      if (this.data.charAt(i) != this.seperator)
        continue;
      if (currentColumnCount >= this.maxColumCount)
      {
        break;
      }
      currentColumnCount++;
      this.columnPosition[currentColumnCount] = (i + 1);
    }

    if ((!this.flexible) && (currentColumnCount < this.maxColumCount - 1))
    {
      throw new RuntimeException(new StringBuilder().append("invalid line. line:").append(line).toString());
    }
    if (((this.flexible) && (currentColumnCount < this.maxColumCount)) || (currentColumnCount == this.maxColumCount - 1))
    {
      currentColumnCount++;
      this.columnPosition[currentColumnCount] = (length + 1);
      this.columnCount = currentColumnCount;
    }
    else
    {
      this.columnCount = currentColumnCount;
    }
  }

  public final String getStringColumn(int index)
  {
    if ((index < 0) || (index >= this.columnCount))
    {
      return "";
    }

    return this.data.substring(this.columnPosition[index], this.columnPosition[(index + 1)] - 1);
  }



  public boolean isFlexible() {
    return this.flexible;
  }

  public void setFlexible(boolean flexible) {
    this.flexible = flexible;
  }

@Override
public void readFields(DataInput arg0) throws IOException {
	// TODO Auto-generated method stub
	
}

@Override
public void write(DataOutput arg0) throws IOException {
	// TODO Auto-generated method stub
	
}

}