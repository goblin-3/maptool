/*
 * This software Copyright by the RPTools.net development team, and
 * licensed under the Affero GPL Version 3 or, at your option, any later
 * version.
 *
 * MapTool Source Code is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * You should have received a copy of the GNU Affero General Public
 * License * along with this source Code.  If not, please visit
 * <http://www.gnu.org/licenses/> and specifically the Affero license
 * text at <http://www.gnu.org/licenses/agpl.html>.
 */
package net.rptools.maptool.model.gamedata;

import java.util.List;
import java.util.Map;
import net.rptools.maptool.language.I18N;

/** The IntegerDataValue class represents a data value that is a double. */
public final class DoubleDataValue implements DataValue {

  /** The name of the value. */
  private final String name;
  /** The value. */
  private final double value;

  /**
   * Creates a new DoubleDataValue.
   * @param name the name of the value.
   * @param value the value.
   */
  DoubleDataValue(String name, double value) {
    this.name = name;
    this.value = value;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public DataType getDataType() {
    return DataType.DOUBLE;
  }

  @Override
  public boolean canBeConvertedTo(DataType dataType) {
    return switch (dataType) {
      case LONG, DOUBLE, BOOLEAN, STRING, LIST -> true;
      case MAP, UNDEFINED -> false;
    };
  }

  @Override
  public long asLong() {
    return (long) value;
  }

  @Override
  public double asDouble() {
    return value;
  }

  @Override
  public String asString() {
    return Double.toString(value);
  }

  @Override
  public boolean asBoolean() {
    return value != 0;
  }

  @Override
  public List<DataValue> asList() {
    return List.of(this);
  }

  @Override
  public Map<String, DataValue> asMap() {
    throw new IllegalStateException(
        I18N.getText("data.error.cantConvertTo", DataType.DOUBLE.name(), DataType.MAP.name()));
  }
}
