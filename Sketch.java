import processing.core.PApplet;
import processing.event.MouseEvent;

/**
 * Demonstrates keyboard and mouse interactions.
 * The sketch moves a white circle with arrow keys and can also change
 * the background color with the keys 'r', 'g', and 'b'. It also has 
 * visual feedback for mouse inputs and actions.
 */
public class Sketch extends PApplet {

  // Booleans to track the state of arrow key presses
  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;

  // Circle's position and movement speed
  float circleX = 150;
  float circleY = 150;
  float speed = 2;

  /**
   * Sets the size of the window.
   */
  public void settings() {
    size(300, 300);
  }

  /**
   * Called once when the program starts. Used to set the initial background color.
   */
  public void setup() {
    background(0);
  }

  /**
   * Called repeatedly to draw the contents of the window.
   * Handles the movement of the circle and changes the background color based on key presses.
   */
  public void draw() {
    background(0); // Clear background each frame to avoid artifacts

    // Handle keyPressed color changes
    if (keyPressed) {
      if (key == 'r') {
        background(255, 0, 0);
      } else if (key == 'g') {
        background(0, 255, 0);
      } else if (key == 'b') {
        background(0, 0, 255);
      }
    }

    // Handle circle movement
    if (upPressed) {
      circleY -= speed;
    }
    if (downPressed) {
      circleY += speed;
    }
    if (leftPressed) {
      circleX -= speed;
    }
    if (rightPressed) {
      circleX += speed;
    }

    // Ensure the circle stays within the window boundaries
    if (circleX < 25) {
      circleX = 25;
    } else if (circleX > width - 25) {
      circleX = width - 25;
    }
    if (circleY < 25) {
      circleY = 25;
    } else if (circleY > height - 25) {
      circleY = height - 25;
    }

    fill(255); // White color for the circle
    ellipse(circleX, circleY, 50, 50);
  }

  /**
   * Called when the mouse is pressed. Draws a yellow circle at the mouse position.
   */
  public void mousePressed() {
    fill(255, 255, 0); // Yellow color when mouse is pressed
    ellipse(mouseX, mouseY, 50, 50);
  }

  /**
   * Called when the mouse is moved. Draws a small white circle at the mouse position to provide visual feedback.
   */
  public void mouseMoved() {
    fill(255); // White color for the small circle
    ellipse(mouseX, mouseY, 10, 10);
  }

  /**
   * Called when the mouse is dragged. Draws a red rectangle at the mouse position.
   */
  public void mouseDragged() {
    fill(255, 0, 0); // Red color for rectangles
    rect(mouseX, mouseY, 50, 50);
  }

  /**
   * Called when a key is pressed. Changes the background color based on key and sets movement flags for arrow keys.
   */
  public void keyPressed() {
    if (key == 'r') {
      background(255, 0, 0); // Red background
    } else if (key == 'g') {
      background(0, 255, 0); // Green background
    } else if (key == 'b') {
      background(0, 0, 255); // Blue background
    }

    if (keyCode == UP) {
      upPressed = true;
    } else if (keyCode == DOWN) {
      downPressed = true;
    } else if (keyCode == LEFT) {
      leftPressed = true;
    } else if (keyCode == RIGHT) {
      rightPressed = true;
    }
  }

  /**
   * Called when a key is released. Resets the movement flags for arrow keys.
   */
  public void keyReleased() {
    if (keyCode == UP) {
      upPressed = false;
    } else if (keyCode == DOWN) {
      downPressed = false;
    } else if (keyCode == LEFT) {
      leftPressed = false;
    } else if (keyCode == RIGHT) {
      rightPressed = false;
    }
  }
}
