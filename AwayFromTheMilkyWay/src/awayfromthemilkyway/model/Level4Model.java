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
public class Level4Model {
    
    SpaceshipModel spaceship = new SpaceshipModel(60.0, 400.0, 35.0, 1);
    
    MilkyWayModel milkyway = new MilkyWayModel(1125.0, 400.0, 50.0);
    
    ObstacleCollisionModel planet = new ObstacleCollisionModel(250.0, 728.0, 47.0);
    
    ObstacleEnemyModel asteroid = new ObstacleEnemyModel(550.0, 68.0, 37.0);
    
    ObstacleCollisionModel planet2 = new ObstacleCollisionModel(770.0, 68.0, 41.0);
    
}
