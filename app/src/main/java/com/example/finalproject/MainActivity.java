package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv1;
    SearchView sv1;
    public static String s1[] = {"Anti-Mage", "Axe", "Bane", "Bloodseeker", "Crystal Maiden", "Drow Ranger", "Earthshaker", "Juggernaut", "Mirana", "Morphling", "Shadow Fiend", "Phantom Lancer", "Puck", "Pudge", "Razor", "Sand King", "Storm Spirit", "Sven",
            "Tiny", "Vengeful Spirit", "Windranger", "Zeus", "Kunkka", "Lina", "Lion", "Shadow Shaman", "Slardar", "Tidehunter", "Witch Doctor", "Lich", "Riki", "Enigma", "Tinker", "Sniper", "Necrophos", "Warlock", "Beastmaster", "Queen of Pain",
            "Venomancer", "Faceless Void", "Wraith King", "Death Prophet", "Phantom Assassin", "Pugna", "Templar Assassin", "Viper", "Luna", "Dragon Knight", "Dazzle", "Clockwerk", "Leshrac", "Nature's Prophet", "Lifestealer", "Dark Seer", "Clinkz",
            "Omniknight", "Enchantress", "Huskar", "Night Stalker", "Broodmother", "Bounty Hunter", "Weaver", "Jakiro", "Batrider", "Chen", "Spectre", "Ancient Apparition", "Doom", "Ursa", "Spirit Breaker", "Gyrocopter", "Alchemist", "Invoker", "Silencer",
            "Outworld Devourer", "Lycan", "Brewmaster", "Shadow Demon", "Lone Druid", "Chaos Knight", "Meepo", "Treant Protector", "Ogre Magi", "Undying", "Rubick", "Disruptor", "Nyx Assassin", "Naga Siren", "Keeper of the Light", "Io", "Visage",
            "Slark", "Medusa", "Troll Warlord", "Centaur Warrunner", "Magnus", "Timbersaw", "Bristleback", "Tusk", "Skywrath Mage", "Abaddon", "Elder Titan", "Legion Commander", "Techies", "Ember Spirit", "Earth Spirit", "Underlord",
            "Terrorblade", "Phoenix", "Oracle", "Winter Wyvern", "Arc Warden", "Monkey King", "Dark Willow", "Pangolier", "Grimstroke", "Hoodwink", "Void Spirit", "Snapfire", "Mars", "Dawnbreaker"};
    public static Integer imageRes[] = {R.drawable.antimage, R.drawable.axe, R.drawable.bane, R.drawable.bloodseeker, R.drawable.crystal_maiden, R.drawable.drow_ranger, R.drawable.earthshaker, R.drawable.juggernaut, R.drawable.mirana, R.drawable.morphling, R.drawable.nevermore, R.drawable.phantom_lancer, R.drawable.puck, R.drawable.pudge, R.drawable.razor,
            R.drawable.sand_king, R.drawable.storm_spirit, R.drawable.sven, R.drawable.tiny, R.drawable.vengefulspirit, R.drawable.windrunner, R.drawable.zuus, R.drawable.kunkka, R.drawable.lina, R.drawable.lion, R.drawable.shadow_shaman, R.drawable.slardar, R.drawable.tidehunter, R.drawable.witch_doctor, R.drawable.lich,
            R.drawable.riki, R.drawable.enigma, R.drawable.tinker, R.drawable.sniper, R.drawable.necrolyte, R.drawable.warlock, R.drawable.beastmaster, R.drawable.queenofpain, R.drawable.venomancer, R.drawable.faceless_void, R.drawable.skeleton_king, R.drawable.death_prophet, R.drawable.phantom_assassin, R.drawable.pugna, R.drawable.templar_assassin,
            R.drawable.viper, R.drawable.luna, R.drawable.dragon_knight, R.drawable.dazzle, R.drawable.rattletrap, R.drawable.leshrac, R.drawable.furion, R.drawable.life_stealer, R.drawable.dark_seer, R.drawable.clinkz, R.drawable.omniknight, R.drawable.enchantress, R.drawable.huskar, R.drawable.night_stalker, R.drawable.broodmother,
            R.drawable.bounty_hunter, R.drawable.weaver, R.drawable.jakiro, R.drawable.batrider, R.drawable.chen, R.drawable.spectre, R.drawable.ancient_apparition, R.drawable.doom_bringer, R.drawable.ursa, R.drawable.spirit_breaker, R.drawable.gyrocopter, R.drawable.alchemist, R.drawable.invoker, R.drawable.silencer, R.drawable.obsidian_destroyer,
            R.drawable.lycan, R.drawable.brewmaster, R.drawable.shadow_demon, R.drawable.lone_druid, R.drawable.chaos_knight, R.drawable.meepo, R.drawable.treant, R.drawable.ogre_magi, R.drawable.undying, R.drawable.rubick, R.drawable.disruptor, R.drawable.nyx_assassin, R.drawable.naga_siren, R.drawable.keeper_of_the_light, R.drawable.wisp,
            R.drawable.visage, R.drawable.slark, R.drawable.medusa, R.drawable.troll_warlord, R.drawable.centaur, R.drawable.magnataur, R.drawable.shredder, R.drawable.bristleback, R.drawable.tusk, R.drawable.skywrath_mage, R.drawable.abaddon, R.drawable.elder_titan, R.drawable.legion_commander, R.drawable.techies, R.drawable.ember_spirit,
            R.drawable.earth_spirit, R.drawable.abyssal_underlord, R.drawable.terrorblade, R.drawable.phoenix, R.drawable.oracle, R.drawable.winter_wyvern, R.drawable.arc_warden, R.drawable.monkey_king, R.drawable.dark_willow, R.drawable.pangolier, R.drawable.grimstroke, R.drawable.hoodwink, R.drawable.void_spirit, R.drawable.snapfire, R.drawable.mars,
            R.drawable.dawnbreaker};
    public static Integer ids[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51,
            52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101,
            102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 119, 120, 121, 123, 126, 128, 129, 135};
    Adapter ad;
    ArrayList <String> data = new ArrayList<>();
    ArrayList <Integer> img = new ArrayList<>();
    ArrayList <Integer> imgAll = new ArrayList<>();
    ImageView dHero[] = new ImageView[5];
    ImageView rHero[] = new ImageView[5];
    int dImgId[] = new int[]{R.id.dire_hero1, R.id.dire_hero2, R.id.dire_hero3, R.id.dire_hero4, R.id.dire_hero5};
    int rImgId[] = new int[]{R.id.radiant_hero1, R.id.radiant_hero2, R.id.radiant_hero3, R.id.radiant_hero4, R.id.radiant_hero5};
    int cntd, cntr;
    int rId[] = new int[5];
    int dId[] = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 5; i++){
            dHero[i] = findViewById(dImgId[i]);
            rHero[i] = findViewById(rImgId[i]);
        }
        cntd = cntr = 0;
        rv1 = findViewById(R.id.rv1);
        data.addAll(Arrays.asList(s1));
        imgAll.addAll(Arrays.asList(imageRes));
        img.addAll(Arrays.asList(imageRes));
        ad = new Adapter(this, data, img);
        rv1.setAdapter(ad);
        rv1.setLayoutManager(new LinearLayoutManager(this));
        sv1 = findViewById(R.id.sv1);
        sv1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ad.getFilter().filter(newText);
                return false;
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(rv1);
    }
    ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
            int dragFlags = 0;
            int swipeFlags = ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT;
            if (cntd > 4){
                swipeFlags = ItemTouchHelper.RIGHT;
            }
            if (cntr > 4){
                swipeFlags = ItemTouchHelper.LEFT;
            }
            if (cntr > 4 && cntd > 4){
                swipeFlags = 0;
            }
            return makeMovementFlags(dragFlags, swipeFlags);
        }

        @Override
        public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
            int position = viewHolder.getAdapterPosition();
            switch (direction){
                case ItemTouchHelper.LEFT:
                    if (cntd > 4){
                        return;
                    }
                    dId[cntd] = ids[imgAll.indexOf(img.get(position))];
                    dHero[cntd].setImageResource(img.get(position));
                    cntd++;
                    break;
                case ItemTouchHelper.RIGHT:
                    if (cntr > 4){
                        return;
                    }
                    rId[cntr] = ids[imgAll.indexOf(img.get(position))];
                    rHero[cntr].setImageResource(img.get(position));
                    cntr++;
                    break;
            }
            ad.notifyItemRemoved(position);
            ad.dataAll.remove(ad.data.get(position));
            ad.imgAll.remove(ad.img.get(position));
            ad.data.remove(position);
            ad.img.remove(position);
        }
    };

    public void suggestHero(View view) {
        Intent intent = new Intent(this, Suggestion.class);
        intent.putExtra("dire", dId);
        intent.putExtra("radiant", rId);
        intent.putExtra("dsize", cntd);
        intent.putExtra("rsize", cntr);
        startActivity(intent);
    }
}