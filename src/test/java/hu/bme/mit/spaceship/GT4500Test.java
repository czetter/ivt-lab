package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {
  private TorpedoStore mockTSp;
  private GT4500 ship;

  @BeforeEach
  public void init(){
    this.mockTSp = mock(TorpedoStore.class);
    this.ship = new GT4500(this.mockTSp);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(ship.fireTorpedo(FiringMode.SINGLE)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(mockTSp,times(1)).result;
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(ship.fireTorpedo(FiringMode.ALL)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    verify(mockTSp,times(1)).result;
  }

}
