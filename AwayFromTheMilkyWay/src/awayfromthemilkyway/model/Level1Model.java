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
public class Level1Model{
    
    SpaceshipModel spaceship = new SpaceshipModel(60.0, 400.0, 35.0, 1);
    
    MilkyWayModel milkyway = new MilkyWayModel(1125.0, 400.0, 50.0);
    
    ObstacleCollisionModel planet = new ObstacleCollisionModel(600.0, 68.0, 43.0);
    
}
