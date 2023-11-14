package dev.abruno.dnd_service.character.util;

import java.util.Random;

public class RandomNameGenerator {

    //Credit to https://www.scarymommy.com/pregnancy/fantasy-names
    private static String[] firstNames = {"Aldwyn", "Atreyu", "Artemis", "Bastian", "Ben", "Bronn", "Cullen", "Daario", "Draco", "Eddard", "Emmett", "Eowyn", "Falkor", "Faramir", "Finn", "Gregor", "Jaime", "Jaqen", "Jorah", "Loras", "Luke", "Petyr", "Pippin", "Poe", "Ramsay", "Ren", "Rool", "Roose", "Samwise", "Sandor", "Sirius", "Shasta", "Stannis", "Sulu", "Theon", "Tirian", "Aalya", "Aerin", "Allyrion", "Ammae", "Apperford", "Arinalue", "Arrely", "Arwynn", "Ashford", "Aurola", "Avilyn", "Avitihne", "Bancey", "Bayle", "Beatsarda", "Beesbury", "Beicaryn", "Camyla", "Crane", "Daedi", "Donnis", "Durwell", "Eilgolor", "Elbereth", "Elrora", "Elyana", "Esalin", "Estel", "Esthis", "Eyva", "Faenys", "Gaenzira", "Garner", "Gifmedha", "Gislila", "Glynrie", "Gresnalyn", "Haleth", "Halyziar", "Helehorn", "Herdan", "Jaidyn", "Jelissa", "Joansevel", "Johvis", "Keyvyre", "Kririah", "Laerra", "Leodove", "Lia", "Liamyar", "Liayra", "Maryana", "Melian", "Meya", "Mirazumin", "Morwen", "Norrey", "Norydark", "Ololar", "Oloxina", "Pabanise", "Parge", "Reyanna", "Reyanna", "Rina", "Sesa", "Shaed", "Siofra", "Sylvina", "Tallhart", "Taner", "Teflorna", "Teftrana", "Umezorwyn", "Valxina", "Vicraera", "Virdan", "Waker", "Wynna", "Yinlee", "Yvkiasha"};
    private static String[] lastNames = {"Akibrus", "Aleera", "Alva", "Angun", "Balrus", "Breya", "Bulruk", "Caldor", "Ciscra", "Dagen", "Darvyn", "Delvin", "Dracyian", "Drusila", "Lunarex", "Mireille", "Nyssa", "Olwyn", "Peregrine", "Remus", "Rorik", "Shikta", "Soril", "Turilla", "Zarek "};

    private static Random rand = new Random();

    public static String getRandomName(){
        return firstNames[rand.nextInt(firstNames.length)] + " " + lastNames[rand.nextInt(lastNames.length)];
    }
}
