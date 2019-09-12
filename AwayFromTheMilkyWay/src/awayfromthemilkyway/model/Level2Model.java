/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package awayfromthemilkyway.model;

/**
 *
 * @author Stefania
 */
public class Level2Model {
    
    SpaceshipModel spaceship = new SpaceshipModel(60.0, 400.0, 35.0, 1);
    
    MilkyWayModel milkyway = new MilkyWayModel(1125.0, 400.0, 50.0);
    
    ObstacleCollisionModel planet1 = new ObstacleCollisionModel(300.0, 68.0, 43.0);
    
    ObstacleCollisionModel planet2 = new ObstacleCollisionModel(700.0, 728.0, 47.0);
}
