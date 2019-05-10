package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {
  private TorpedoStore mockTS1;
  private TorpedoStore mockTS2;
  private GT4500 ship;

  @BeforeEach
  public void init(){
    this.mockTS1 = mock(TorpedoStore.class);
    this.mockTS2 = mock(TorpedoStore.class);
    this.ship = new GT4500(this.mockTS1, this.mockTS2);
  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(mockTS1.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);

    verify(mockTS1, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
    when(mockTS1.fire(1)).thenReturn(true);
    when(mockTS2.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
    assertEquals(true, result);

    verify(mockTS1, times(1)).fire(1);
    verify(mockTS2, times(1)).fire(1);
  }

  //Extra 5 teszt
  @Test
  public void firetwice(){
    // Arrange
    when(mockTS1.fire(1)).thenReturn(true);
    when(mockTS2.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);
    boolean result2 = ship.fireTorpedo(FiringMode.SINGLE);

    verify(mockTS1, times(1)).fire(1);
    verify(mockTS2, times(1)).fire(1);
  }

  @Test
  public void firethreetimes(){
    // Arrange
    when(mockTS1.fire(1)).thenReturn(true);
    when(mockTS2.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);
    boolean result2 = ship.fireTorpedo(FiringMode.SINGLE);
    boolean result3 = ship.fireTorpedo(FiringMode.SINGLE);

    verify(mockTS1, times(2)).fire(1);
    verify(mockTS2, times(1)).fire(1);
  }

  @Test
  public void fireEmpty(){
    // Arrange
    when(mockTS1.isEmpty()).thenReturn(true);
    when(mockTS1.fire(1)).thenReturn(true);
    when(mockTS2.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);

    verify(mockTS2, times(1)).fire(1);
  }

  @Test
  public void firebothEmpty(){
    // Arrange
    when(mockTS1.isEmpty()).thenReturn(true);
    when(mockTS2.isEmpty()).thenReturn(true);
    when(mockTS1.fire(1)).thenReturn(true);
    when(mockTS2.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(false, result);

    verify(mockTS1, times(0)).fire(1);
    verify(mockTS2, times(0)).fire(1);
  }

  @Test
  public void fireallEmpty(){
    // Arrange
    when(mockTS1.isEmpty()).thenReturn(true);
    when(mockTS1.fire(1)).thenReturn(true);
    when(mockTS2.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    assertEquals(true, result);

    verify(mockTS1, times(0)).fire(1);
    verify(mockTS2, times(1)).fire(1);
  }

}
