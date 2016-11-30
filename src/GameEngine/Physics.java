/**
 *
 *
 * @author Daniel Karlsson 2016
 */
package GameEngine;


public class Physics extends Component {

    // Holds data related to physics
    
    private float mass;
    private float xVelocity = 0, yVelocity = 0;
    private float maxVelocity, minVelocity;
    private float acceleration = 10f;
    private static float absoluteMaxVelocity = 100;
    private boolean moveUp = false, moveRight = false, moveDown = false, moveLeft = false, grounded = false;
    private long jumpDuration = 1000;
    private Timer jumpTimer = new Timer(jumpDuration);
    
    //TODO: Velocity in opposit directions doesn't cancel eachother out
    //TODO: Acceleration up/left is slower than acceleration down/right
    
    public Physics(float mass) {
        compType = Constants.ComponentType.physics;
        this.mass = mass;
        maxVelocity = absoluteMaxVelocity/mass;
        minVelocity = -maxVelocity;
        
        acceleration = maxVelocity*2;
        
        if(maxVelocity < 1) {
            maxVelocity = 1;
            minVelocity = -maxVelocity;
        } else if(maxVelocity > absoluteMaxVelocity) {
            maxVelocity = absoluteMaxVelocity;
            minVelocity = -maxVelocity;
        }
    }
    
    @Override
    public void tick(float delta) {
        //Vertical
        if(moveUp && moveDown) {
            moveUp = false;
            moveDown = false;
        }
        if(moveUp || isJumping()) {
            moveUp = true;
            yVelocity -= acceleration*5*delta;
        }
        if(moveDown) {
            yVelocity += acceleration*delta;
        }
        
        //Horizontal
        if(moveRight && moveLeft) {
            moveRight = false;
            moveLeft = false;
        }
        if(moveRight) {
            xVelocity += acceleration*delta;
        }
        if(moveLeft) {
            xVelocity -= acceleration*delta;
        }
        
        //Lock velocity
        if(yVelocity > maxVelocity) {
            yVelocity = maxVelocity;
        } else if(yVelocity < minVelocity) {
            yVelocity = minVelocity;
        }
        if(xVelocity > maxVelocity) {
            xVelocity = maxVelocity;
        } else if(xVelocity < minVelocity) {
            xVelocity = minVelocity;
        }
        
        //Slow down
        if(!moveUp && !moveDown) {
            if((yVelocity < 0.001 && yVelocity >0) || (yVelocity > -0.001 && yVelocity < 0)) {
                yVelocity = 0;
            } else {
                if(yVelocity < 0) {
                    yVelocity += acceleration*delta;
                }else if(yVelocity > 0) {
                    yVelocity -= acceleration*delta;
                }
            }
        }
        if(!moveRight && !moveLeft) {
            if((xVelocity < 0.001 && xVelocity > 0) || (xVelocity > -0.001 && xVelocity < 0)) {
                xVelocity = 0;
            } else {
                if(xVelocity < 0) {
                    xVelocity += acceleration*delta;
                } else if(xVelocity > 0) {
                    xVelocity -= acceleration*delta;
                }
            }
        }
        
        moveUp = false;
        moveRight = false;
        moveDown = false;
        moveLeft = false;
    }
    
    public void moveUp() {
        if(grounded || isJumping()) {
            if(grounded) {
                //grounded = false;
                jumpTimer.reset();
            }
            moveUp = true;
        }
    }
    
    public void moveRight() {
        moveRight = true;
    }
    
    public void moveDown() {
        moveDown = true;
    }
    
    public void moveLeft() {
        moveLeft = true;
    }
    
    public float getXVelocity() {
        return xVelocity;
    }
    
    public float getYVelocity() {
        return yVelocity;
    }
    
    public float getMass() {
        return mass;
    }
    
    public void setGrounded(boolean grounded) {
        this.grounded = grounded;
    }
    
    public boolean isGrounded() {
        return grounded;
    }
    
    public boolean isJumping() {
        if(jumpTimer.getRunTime() < jumpDuration) {
            return true;
        }
        return false;
    }

}
