package dev.greenadine.amazingtool.gladesolver;

import java.util.HashMap;

public class Costs {

    private final HashMap<CostItem, Integer> costs;

    public Costs() {
        this.costs = new HashMap<>();

        /* Set defaults */

        // Hardware
        setCost(CostItem.AANSCHAF_KOMPAS, 100);
        setCost(CostItem.AANSCHAF_ZW_OOG, 50);
        setCost(CostItem.AANSCHAF_KLEUR_OOG, 200);
        setCost(CostItem.AANSCHAF_VARIABELE, 30);

        // Software
        setCost(CostItem.ZOLANG, 50);
        setCost(CostItem.ALS, 40);
        setCost(CostItem.OPDRACHT, 20);
        setCost(CostItem.TOEKENNING, 10);

        // Action
        setCost(CostItem.STAP_VOORUIT, 1);
        setCost(CostItem.STAP_ACTHERUIT, 1);
        setCost(CostItem.DRAAI_LINKS, 5);
        setCost(CostItem.DRAAI_RECHTS, 5);
        setCost(CostItem.GEBRUIK_ZW_OOG, 15);
        setCost(CostItem.GEBRUIK_KLEUR_OOG, 20);
        setCost(CostItem.AANSCHAF_KOMPAS, 15);
    }

    public final int getCost(final CostItem item) {
        return costs.get(item);
    }

    public final void setCost(final CostItem item, final int cost) {
        costs.put(item, cost);
    }
}
