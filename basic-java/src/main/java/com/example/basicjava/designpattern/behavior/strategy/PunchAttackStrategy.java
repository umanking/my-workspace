package com.example.basicjava.designpattern.behavior.strategy;

/**
 * @author Geonguk Han
 * @since 2020-07-15
 */
public class PunchAttackStrategy implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("펀치 공격");
    }
}
