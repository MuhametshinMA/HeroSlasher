package com.example.gear2d;

public class CollisionDetectFW {
    static double object1X;
    static double object1Y;
    static double object2X;
    static double object2Y;
    static double radiusObject1;
    static double radiusObject2;
    static double dx;
    static double dy;
    static double distanceObject;

    public static boolean collisionDetect(ObjectsFW object1, ObjectsFW object2) {
        object1X = object1.getHitBox().centerX();
        object1Y = object1.getHitBox().centerY();

        object2X = object2.getHitBox().centerX();
        object2Y = object2.getHitBox().centerY();

        radiusObject1 = object1.getRadius();
        radiusObject2 = object2.getRadius();

        dx = object1X - object2X;
        dy = object1Y - object2Y;

        distanceObject = Math.sqrt(dx*dx + dy*dy);

        if (distanceObject < (radiusObject1 + radiusObject2)) {
            return true;
        }
        return false;
    }
}
