package com.company;

import com.company.modele.Panstwo;
import com.company.wspolczynniki_mechaniki.StanSektoraPanstwa;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ListaPanstw {


    private List<Panstwo> listaPanstw = Arrays.asList(

            new Panstwo("MEKSYK", 913, 1449, 124574795,
                    Arrays.asList("USA", "GWATEMALA"), StanSektoraPanstwa.BARDZO_DOBRY, StanSektoraPanstwa.DOBRY,
                    true, true),

            new Panstwo("KUBA", 1371, 1483, 11147407,
                    null, StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.SREDNI, false, true),

            new Panstwo("GWATEMALA", 1138,1615, 16919000,
                    Arrays.asList("SALWADOR", "HONDURAS", "MEKSYK"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("HONDURAS",1198,1652, 8307000,
                    Arrays.asList("NIKARAGUA", "SALWADOR", "GWATEMALA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SREDNI,
                    false, true),

            new Panstwo("SALWADOR", 1151, 1675, 6369000,
                    Arrays.asList("NIKARAGUA", "SALWADOR", "HONDURAS"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("NIKARAGUA", 1226, 1698, 6025951,
                    Arrays.asList("KOSTARYKA", "SALWADOR", "HONDURAS"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("KOSTARYKA", 1241, 1762, 4968000,
                    Arrays.asList("PANAMA", "NIKARAGUA"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("PANAMA", 1334, 1749, 3753142,
                    Arrays.asList("KOLUMBIA", "KOSTARYKA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("KOLUMBIA", 1437, 1890, 49292000,
                    Arrays.asList("PANAMA", "EKWADOR", "WENEZUELA", "PERU", "BRAZYLIA"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("WENEZUELA", 1606, 1811, 31431000,
                    Arrays.asList("KOLUMBIA", "GUJANA", "BRAZYLIA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("EKWADOR", 1320, 2016, 16777000,
                    Arrays.asList("KOLUMBIA", "BRAZYLIA", "PERU"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("PERU", 1385, 2231, 33036196,
                    Arrays.asList("EKWADOR", "BRAZYLIA", "BOLIWIA", "KOLUMBIA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("BOLIWIA",1655, 2380, 11071000,
                    Arrays.asList("PERU", "BRAZYLIA", "PARAGWAJ", "ARGENTYNA", "CHILE"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("CHILE", 1576, 2718, 18383000,
                    Arrays.asList("PERU", "BOLIWIA", "ARGENTYNA"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("ARGENTYNA", 1709, 2784, 44082000,
                    Arrays.asList("CHILE", "URUGWAJ", "BRAZYLIA", "PARAGWAJ", "BOLIWIA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, true),

            new Panstwo("PARAGWAJ", 1792, 2530, 6943739,
                    Arrays.asList("ARGENTYNA", "BOLIWIA", "BRAZYLIA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("URUGWAJ", 1907, 2766, 3360148,
                    Arrays.asList("ARGENTYNA", "BRAZYLIA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.DOBRY,
                    false, false),

            new Panstwo("BRAZYLIA", 1904, 2199, 210677000,
                    Arrays.asList("URUGWAJ", "ARGENTYNA", "PARAGWAJ", "BOLIWIA", "PERU", "KOLUMBIA", "WENEZUELA", "GUJANA", "SURINAM", "GUJANA FRANCUSKA"),
                    StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI, true, true),

            new Panstwo("GUJANA", 1753, 1884, 770000,
                    Arrays.asList("WENEZUELA", "SURINAM", "BRAZYLIA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("SURINAM", 1815, 1897, 597927,
                    Arrays.asList("GUJANA", "GUJANA FRANCUSKA", "BRAZYLIA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("GUJANA FRANCUSKA", 1876, 1903, 232223,
                    Arrays.asList("SURINAM", "BRAZYLIA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("HAITI", 1430, 1561, 11117000,
                    Arrays.asList("DOMINIKANA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("DOMINIKANA", 1586, 1545, 10172000,
                    Arrays.asList("HAITI"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("GRENDLANDIA", 2451, 332, 57713,
                    null, StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.DOBRY,
                    false, true),

            new Panstwo("ISLANDIA", 2729, 517, 360390,
                    null, StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.DOBRY,
                    true, true),

            new Panstwo("IRLANDIA", 2822, 767, 4728000,
                    Arrays.asList("WIELKA BRYTANIA"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.DOBRY,
                    false, true),

            new Panstwo("WIELKA BRYTANIA", 2963, 755, 66040200,
                    Arrays.asList("IRLANDIA"), StanSektoraPanstwa.BARDZO_DOBRY, StanSektoraPanstwa.DOBRY,
                    true, true),

            new Panstwo("NORWEGIA",  3132, 589, 5367580,
                    Arrays.asList("FINLANDIA", "ROSJA", "SZWECJA"), StanSektoraPanstwa.BARDZO_DOBRY, StanSektoraPanstwa.BARDZO_DOBRY,
                    false, true),

            new Panstwo("SZWECJA", 3240, 569, 10281189,
                    Arrays.asList("NORWEGIA", "FINLANDIA"), StanSektoraPanstwa.BARDZO_DOBRY, StanSektoraPanstwa.BARDZO_DOBRY,
                    false, true),

            new Panstwo("FINLANDIA", 3421, 547, 5503000,
                    Arrays.asList("SZWECJA", "NORWEGIA", "ROSJA"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.DOBRY,
                    false, false),

            new Panstwo("POLSKA",  3333, 786, 38386000,
                    Arrays.asList("NIEMCY", "UKRAINA", "BIAŁORUŚ", "LITWA", "CZECHY", "SŁOWACJA"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("NIEMCY", 3167, 802, 83019200,
                    Arrays.asList("HOLANDIA", "BELGIA", "FRANCJA", "SZWAJCARIA", "AUSTRIA", "CZECHY", "POLSKA", "DANIA"),
                    StanSektoraPanstwa.WYSMIENITY, StanSektoraPanstwa.BARDZO_DOBRY, true, true),

            new Panstwo("LITWA", 3407, 717, 2802047,
                    Arrays.asList("POLSKA", "BIAŁORUŚ", "ŁOTWA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.DOBRY,
                    false, true),

            new Panstwo("BIAŁORUŚ", 3479, 756, 9451000,
                    Arrays.asList("POLSKA", "LITWA", "UKRAINA", "ŁOTWA", "ROSJA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("UKRAINA", 3543, 847, 3789000,
                    Arrays.asList("BIAŁORUŚ", "POLSKA", "SŁOWACJA", "WĘGRY", "MOŁDAWIA", "ROSJA", "RUMUNIA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("CZECHY", 3264, 841, 10649800,
                    Arrays.asList("POLSKA", "NIEMCY", "AUSTRIA", "SŁOWACJA"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.DOBRY,
                    false, false),

            new Panstwo("SŁOWACJA", 3346, 862, 5445802,
                    Arrays.asList("AUSTRIA", "POLSKA", "CZECHY", "UKRAINA", "WĘGRY"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.DOBRY,
                    false, false),

            new Panstwo("AUSTRIA", 3252, 890, 8859992,
                    Arrays.asList("NIEMCY", "CZECHY", "WŁOCHY", "WĘGRY", "SŁOWENIA", "SZWAJCARIA", "SŁOWACJA"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.DOBRY,
                    false, false),

            new Panstwo("WĘGRY", 3341, 901, 9805000,
                    Arrays.asList("RUMUNIA", "SERBIA", "CHORWACJA", "SŁOWENIA", "AUSTRIA", "SŁOWACJA", "UKRAINA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("SZWAJCARIA", 3144, 904, 8526932,
                    Arrays.asList("NIEMCY", "FRANCJA", "WŁOCHY", "AUSTRIA"), StanSektoraPanstwa.WYSMIENITY, StanSektoraPanstwa.BARDZO_DOBRY,
                    false, false),

            new Panstwo("WŁOCHY", 3212, 990, 60483973,
                    Arrays.asList("FRANCJA", "SZWAJCARIA", "AUSTRIA", "SŁOWENIA"), StanSektoraPanstwa.BARDZO_DOBRY, StanSektoraPanstwa.BARDZO_DOBRY,
                    true, false),

            new Panstwo("FRANCJA", 3030, 909, 67022000,
                    Arrays.asList("BELGIA", "NIEMCY", "SZWAJCARIA", "WŁOCHY", "HISZPANIA"), StanSektoraPanstwa.BARDZO_DOBRY, StanSektoraPanstwa.DOBRY,
                    true, true),

            new Panstwo("HISZPANIA", 2916, 1063, 47100396,
                    Arrays.asList("PORTUGALIA", "FRANCJA"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.BARDZO_DOBRY,
                    true, true),

            new Panstwo("PORTUGALIA", 2823, 1070, 10833816,
                    Arrays.asList("HISZPANIA"), StanSektoraPanstwa.BARDZO_DOBRY, StanSektoraPanstwa.DOBRY,
                    false, false),

            new Panstwo("HOLANDIA", 3090, 783, 17303291,
                    Arrays.asList("BELGIA", "NIEMCY"), StanSektoraPanstwa.BARDZO_DOBRY, StanSektoraPanstwa.BARDZO_DOBRY,
                    false, false),

            new Panstwo("BELGIA", 3077, 823, 11303528,
                    Arrays.asList("NIEMCY", "FRANCJA", "HOLANDIA"), StanSektoraPanstwa.WYSMIENITY, StanSektoraPanstwa.BARDZO_DOBRY,
                    false, false),

            new Panstwo("ŁOTWA", 3423, 683, 1950000,
                    Arrays.asList("ESTONIA", "LITWA", "BIAŁORUŚ", "ROSJA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.DOBRY,
                    false, false),

            new Panstwo("ESTONIA", 3434, 644, 1309000,
                    Arrays.asList("ŁOTWA", "ROSJA"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.DOBRY,
                    false, false),

            new Panstwo("SŁOWENIA", 3258, 920, 2061952,
                    Arrays.asList("WŁOCHY", "AUSTRIA", "WĘGRY", "CHORWACJA"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.DOBRY,
                    false, false),

            new Panstwo("CHORWACJA", 3289, 934, 4149000,
                    Arrays.asList("SŁOWENIA", "WĘGRY", "SERBIA", "BOŚNIA I HARCEGOWINA"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.DOBRY,
                    false, false),

            new Panstwo("BOŚNIA I HARCEGOWINA", 3313, 967, 3507000,
                    Arrays.asList("CHORWACJA", "SERBIA", "CZARNOGÓRA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("SERBIA", 3371, 974, 7111024,
                    Arrays.asList("WĘGRY", "RUMUNIA", "BUŁGARIA", "MACEDONIA", "ALBANIA", "CZARNOGÓRA", "CHORWACJA", "BOŚNIA I HARCEGOWINA"),
                    StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI, false, false),

            new Panstwo("CZARNOGÓRA", 3342, 996, 623000,
                    Arrays.asList("SERBIA", "CHORWACJA", "BOŚNIA I HARCEGOWINA", "ALBANIA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("ALBANIA", 3360, 1035, 3038594,
                    Arrays.asList("GRECJA", "CZARNOGÓRA", "MACEDONIA", "SERBIA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("MACEDONIA", 3392, 1025, 2076000,
                    Arrays.asList("ALBANIA", "SERBIA", "BUŁGARIA", "GRECJA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("BUŁGARIA", 3450, 1000, 7061000,
                    Arrays.asList("RUMUNIA", "SERBIA", "MACEDONIA", "GRECJA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("GRECJA", 3428, 1098, 10768000,
                    Arrays.asList("ALBANIA", "MACEDONIA", "BUŁGARIA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("RUMUNIA", 3439, 923, 19250617,
                    Arrays.asList("BUŁGARIA", "SERBIA", "WĘGRY", "UKRAINA", "MOŁDAWIA"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("MOŁDAWIA", 3510, 901, 3553100,
                    Arrays.asList("UKRAINA", "RUMUNIA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("TURCJA", 3657, 1077, 82835090,
                    Arrays.asList("GRECJA", "BUŁGARIA", "SYRIA", "IRAK", "IRAN", "AZERBEJDŻAN", "ARMENIA", "GRUZJA"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("GRUZJA", 3791, 1012, 3718200,
                    Arrays.asList("ROSJA", "ARMENIA", "TURCJA", "AZERBEJDŻAN"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("ARMENIA", 3831, 1058, 2991000,
                    Arrays.asList("GRUZJA", "IRAN", "AZERBEJDŻAN", "TURCJA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("AZERBEJDŻAN", 3886, 1053, 9822000,
                    Arrays.asList("ROSJA", "GRUZJA", "ARMENIA", "IRAN"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("IRAN", 4042, 1236, 81423000,
                    Arrays.asList("IRAK", "TURCJA", "ARMENIA", "AZERBEJDŻAN", "TURKMENISTAN", "AFGANISTAN", "PAKISTAN"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("SYRIA", 3721, 1175, 22087048,
                    Arrays.asList("TURCJA", "IRAK", "JORDANIA", "LIBAN", "IZRAEL"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.BARDZO_SLABY,
                    false, false),

            new Panstwo("IRAK", 3819, 1229, 38858000,
                    Arrays.asList("IRAN", "TURCJA", "SYRIA", "JORDANIA", "ARABIA SAUDYJSKA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("TURKMENISTAN", 4102, 1079, 5180000,
                    Arrays.asList("IRAN", "KAZACHSTAN", "AFGANISTAN"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("AFGANISTAN", 4258, 1204, 35530000,
                    Arrays.asList("PAKISTAN", "IRAN", "TURKMENISTAN", "UZBEKISTAN", "TADŻYKISTAN", "CHINY"), StanSektoraPanstwa.BARDZO_SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("PAKISTAN", 4336, 1302, 207774520,
                    Arrays.asList("IRAN", "AFGANISTAN", "CHINY", "INDIE"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                            false, false),

            new Panstwo("UZBEKISTAN", 4181, 1031, 33398578,
                    Arrays.asList("TURKMENISTAN", "KAZACHSTAN", "AFGANISTAN", "TADŻYKISTAN", "KIRGISTAN"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("KAZACHSTAN", 4196, 867, 18157078,
                    Arrays.asList("CHINY", "KIRGISTAN", "TURKMENISTAN", "UZBEKISTAN", "ROSJA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.BARDZO_SLABY,
                    false, false),

            new Panstwo("TADŻYKISTAN", 4334, 1096, 7800000,
                    Arrays.asList("UZBEKISTAN", "KIRGISTAN", "CHINY", "AFGANISTAN"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("KIRGISTAN", 4387, 1026, 6263000,
                    Arrays.asList("CHINY", "KAZACHSTAN", "TADŻYKISTAN", "UZBEKISTAN"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("CHINY", 4948, 1185, 1420000000,
                    Arrays.asList("AFGANISTAN", "BHUTAN", "INDIE", "KAZACHSTAN", "KIRGISTAN", "KOREA PŁN.", "LAOS", "BIRMA", "MONGOLIA", "NEPAL", "PAKISTAN", "ROSJA", "TADŻYKISTAN", "WIETNAM"),
                    StanSektoraPanstwa.WYSMIENITY, StanSektoraPanstwa.BARDZO_DOBRY, true, true),

            new Panstwo("MONGOLIA", 4881, 915, 3206408,
                    Arrays.asList("ROSJA", "CHINY"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("INDIE", 4546, 1462, 129638042,
                    Arrays.asList("PAKISTAN", "CHINY", "NEPAL", "BHUTAN", "BANGLADESZ", "BIRMA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    true, true),

            new Panstwo("NEPAL", 4635, 1336, 30485798,
                    Arrays.asList("CHINY", "INDIE"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("BANGLADESZ", 4776, 1443, 163187000,
                    Arrays.asList("INDIE", "BIRMA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("BHUTAN", 4769, 1351, 804000,
                    Arrays.asList("CHINY", "INDIE"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("BIRMA", 4901, 1483, 51419420,
                    Arrays.asList("BANGLADESZ", "INDIE", "CHINY", "LAOS", "TAJLANDIA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("TAJLANDIA", 5019, 1632, 67091089,
                    Arrays.asList("BIRMA", "LAOS", "KAMBODŻA", "MALEZJA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("LAOS",5042, 1530, 6680000,
                    Arrays.asList("BIRMA", "CHINY", "WIETNAM", "KAMBODŻA", "TAJLANDIA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("KAMBODŻA", 5105, 1693, 16013000,
                    Arrays.asList("TAJLANDIA", "LAOS", "WIETNAM"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("WIETNAM", 5183, 1717, 93643000,
                    Arrays.asList("CHINY", "LAOS", "KAMBODŻA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("MALEZJA", 5063, 1892, 32050000,
                    Arrays.asList("TAJLANDIA", "SINGAPUR", "INDONEZJA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, true),

            new Panstwo("SINGAPUR", 5100, 1958, 5607300,
                    Arrays.asList("MALEZJA"), StanSektoraPanstwa.BARDZO_SLABY, StanSektoraPanstwa.DOBRY,
                    false, false),

            new Panstwo("INDONEZJA", 5444, 2063, 261989000,
                    null, StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.DOBRY,
                    true, true),

            new Panstwo("PAPUA-NOWA GWINEA", 5937, 2142, 6909701,
                    Arrays.asList("INDONEZJA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, true),

            new Panstwo("AUSTRALIA", 5659, 2566, 25664300,
                    null, StanSektoraPanstwa.BARDZO_DOBRY, StanSektoraPanstwa.BARDZO_DOBRY,
                    true, true),

            new Panstwo("NOWA ZELANDIA", 6237, 2959, 4510327,
                    null, StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.DOBRY,
                    true, true),

            new Panstwo("TAJWAN", 5396, 1443, 23545963,
                    null, StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("FILIPINY", 5474, 1732, 105893381,
                    null, StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, true),

            new Panstwo("KOREA PŁN.", 5388, 1062, 25643466,
                    Arrays.asList("CHINY", "KOREA PŁD.", "ROSJA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("KOREA PŁD.", 5445, 1152, 51454000,
                    Arrays.asList("KOREA PŁN."), StanSektoraPanstwa.BARDZO_DOBRY, StanSektoraPanstwa.DOBRY,
                    false, false),

            new Panstwo("JAPONIA", 5649, 1135, 125396901,
                    null, StanSektoraPanstwa.WYSMIENITY, StanSektoraPanstwa.BARDZO_DOBRY,
                    true, true),

            new Panstwo("SRI LANKA", 4623, 1821, 20130000,
                    null, StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("DANIA", 3155, 698, 5822763,
                    Arrays.asList("NIEMCY"), StanSektoraPanstwa.WYSMIENITY, StanSektoraPanstwa.BARDZO_DOBRY,
                    false, true),

            new Panstwo("USA", 1062, 1078, 326079000,
                    Arrays.asList("MEKSYK", "KANADA"), StanSektoraPanstwa.WYSMIENITY, StanSektoraPanstwa.SREDNI,
                    true, true),

            new Panstwo("KANADA", 1176, 633, 36708083,
                    Arrays.asList("USA"), StanSektoraPanstwa.BARDZO_DOBRY, StanSektoraPanstwa.BARDZO_DOBRY,
                    true, true),

            new Panstwo("ROSJA", 4473, 548, 146877088,
                    Arrays.asList("NORWEGIA", "FINLANDIA", "ESTONIA", "ŁOTWA", "BIAŁORUŚ", "UKRAINA", "GRUZJA", "AZERBEJDŻAN", "KAZACHSTAN", "CHINY", "MONGOLIA", "KOREA PŁN.", "LITWA"),
                    StanSektoraPanstwa.BARDZO_DOBRY, StanSektoraPanstwa.BARDZO_DOBRY, true, true),


            new Panstwo("JORDANIA", 3693, 1261, 7131000,
                    Arrays.asList("IZRAEL", "SYRIA", "IRAK", "ARABIA SAUDYJSKA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("IZRAEL", 3657, 1258, 8834700,
                    Arrays.asList("LIBAN", "SYRIA", "JORDANIA", "EGIPT"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.DOBRY,
                    false, false),

            new Panstwo("LIBAN", 3675, 1202, 4510000,
                    Arrays.asList("SYRIA", "IZRAEL"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("ARABIA SAUDYJSKA", 3857, 1437, 31787580,
                    Arrays.asList("IRAK", "JORDANIA", "OMAN", "JEMEN", "ZJEDNOCZONE EMIRATY ARABSKIE"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.SREDNI,
                    true, false),

            new Panstwo("JEMEN", 3936, 1625, 29977000,
                    Arrays.asList("ARABIA SAUDYJSKA", "OMAN"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("OMAN", 4106, 1520, 4613241,
                    Arrays.asList("ZJEDNOCZONE EMIRATY ARABSKIE", "ARABIA SAUDYJSKA", "JEMEN"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, true),

            new Panstwo("ZJEDNOCZONE EMIRATY ARABSKIE", 4059, 1441, 9400000,
                    Arrays.asList("ARABIA SAUDYJSKA", "OMAN"), StanSektoraPanstwa.BARDZO_DOBRY, StanSektoraPanstwa.DOBRY,
                    false, false),

            new Panstwo("EGIPT", 3555, 1375, 100000408,
                    Arrays.asList("IZRAEL", "SUDAN", "LIBIA"), StanSektoraPanstwa.DOBRY, StanSektoraPanstwa.SREDNI,
                    true, true),

            new Panstwo("LIBIA", 3318, 1361, 6448000,
                    Arrays.asList("EGIPT", "SUDAN", "CZAD", "NIGER", "ALGIERIA", "TUNEZJA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("TUNEZJA", 3155, 1200, 11403800,
                    Arrays.asList("ALGIERIA", "LIBIA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("ALGIERIA", 3017, 1329, 41537000,
                    Arrays.asList("MAROKO", "MALI", "LIBIA", "TUNEZJA", "NIGER", "MAURETANIA", "SAHARA ZACHODNIA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("MAROKO", 2846, 1244, 33986655,
                    Arrays.asList("ALGIERIA", "SAHARA ZACHODNIA"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("SAHARA ZACHODNIA", 2691, 1422, 406200,
                    Arrays.asList("MAROKO", "ALGIERIA", "MAURETANIA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.BARDZO_SLABY,
                    false, false),

            new Panstwo("MAURETANIA", 2747, 1524, 3758571,
                    Arrays.asList("SENEGAL", "MALI", "ALGIERIA", "SAHARA ZACHODNIA"), StanSektoraPanstwa.BARDZO_SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("MALI", 2925, 1559, 18542000,
                    Arrays.asList("ALGIERIA", "NIGER", "BURKINA FASO", "WKS", "GWINEA", "SENEGAL", "MAURETANIA"), StanSektoraPanstwa.BARDZO_SLABY, StanSektoraPanstwa.BARDZO_SLABY,
                    false, false),

            new Panstwo("NIGER", 3159, 1576, 19245344,
                    Arrays.asList("ALGIERIA", "LIBIA", "CZAD", "NIGERIA", "BENIN", "BURKINA FASO", "MALI"), StanSektoraPanstwa.BARDZO_SLABY, StanSektoraPanstwa.BARDZO_SLABY,
                    false, false),

            new Panstwo("CZAD", 3349, 1629, 12185000,
                    Arrays.asList("LIBIA", "SUDAN", "REPUBLIKA ŚRODKOWOAFRYKAŃSKA", "KAMERUN", "NIGERIA", "NIGER"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("SUDAN", 3572, 1672, 37345935,
                    Arrays.asList("EGIPT", "LIBIA", "CZAD", "REPUBLIKA ŚRODKOWOAFRYKAŃSKA", "DEMOKRATYCZNA REPUBLIKA KONGA", "UGANDA", "KENIA", "ETIOPIA", "ERYTREA"),
                    StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY, false, false),

            new Panstwo("ERYTREA", 3746, 1628, 5933000,
                    Arrays.asList("ETIOPIA", "SUDAN", "DŻIBUTI"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("DŻIBUTI", 3837, 1724, 1020000,
                    Arrays.asList("SOMALIA", "ETIOPIA", "ERYTREA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("ETIOPIA", 3769, 1788, 108386391,
                    Arrays.asList("KENIA", "SUDAN", "DŻIBUTI", "SOMALIA", "ERYTREA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("SOMALIA", 3931, 1876, 11031386,
                    Arrays.asList("DŻIBUTI", "ETIOPIA", "KENIA"), StanSektoraPanstwa.BARDZO_SLABY, StanSektoraPanstwa.BARDZO_SLABY,
                    false, false),

            new Panstwo("REPUBLIKA ŚRODKOWOAFRYKAŃSKA", 3383, 1833,4983000,
                    Arrays.asList("KAMERUN", "CZAD", "SUDAN", "DEMOKRATYCZNA REPUBLIKA KONGA", "KONGO"), StanSektoraPanstwa.BARDZO_SLABY, StanSektoraPanstwa.BARDZO_SLABY,
                    false, false),

            new Panstwo("KAMERUN", 3220, 1863, 24277000,
                    Arrays.asList("NIGERIA", "CZAD", "REPUBLIKA ŚRODKOWOAFRYKAŃSKA", "KONGO", "GABON", "GWINEA RÓWNIKOWA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("NIGERIA", 3123, 1770, 203452505,
                    Arrays.asList("BENIN", "NIGER", "CZAD", "KAMERUN"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("BENIN", 3009, 1777, 11125000,
                    Arrays.asList("BURKINA FASO", "NIGER", "NIGERIA", "TOGO"), StanSektoraPanstwa.BARDZO_SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("TOGO", 2985, 1794, 7965055,
                    Arrays.asList("GHANA", "BENIN", "BURKINA FASO"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("GHANA", 2942, 1802, 28278000,
                    Arrays.asList("TOGO", "BURKINA FASO", "WKS"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("BURKINA FASO", 2925, 1701, 1893000,
                    Arrays.asList("MALI", "NIGER", "BENIN", "TOGO", "GHANA", "WKS"), StanSektoraPanstwa.BARDZO_SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("WKS", 2853, 1809, 24960000,
                    Arrays.asList("MALI", "BURKINA FASO", "LIBERIA", "GWINEA", "GHANA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, true),

            new Panstwo("LIBERIA", 2771, 1844, 4505000,
                    Arrays.asList("GWINEA", "WKS", "SIERRA LEONE"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("GWINEA", 2735, 1737, 12970000,
                    Arrays.asList("GWINEA BISSAU", "SENEGAL", "MALI", "LIBERIA", "WKS", "SIERRA LEONE"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.BARDZO_SLABY,
                    false, false),

            new Panstwo("SIERRA LEONE", 2712, 1795, 6163195,
                    Arrays.asList("GWINEA", "LIBERIA"), StanSektoraPanstwa.BARDZO_SLABY, StanSektoraPanstwa.BARDZO_SLABY,
                    false, false),

            new Panstwo("GWINEA BISSAU", 2660, 1714, 1700000,
                    Arrays.asList("SENEGAL", "GWINEA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.BARDZO_SLABY,
                    false, false),

            new Panstwo("SENEGAL", 2662, 1635, 14668522,
                    Arrays.asList("MAURETANIA", "MALI", "GWINEA", "GWINEA BISSAU", "GAMBIA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("GAMBIA", 2652, 1676, 2103000,
                    Arrays.asList("SENEGAL"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("KENIA", 3738, 1979, 47654296,
                    Arrays.asList("SOMALIA", "ETIOPIA", "UGANDA", "TANZANIA"), StanSektoraPanstwa.BARDZO_SLABY, StanSektoraPanstwa.BARDZO_SLABY,
                    false, false),

            new Panstwo("UGANDA", 3634, 1953, 43252966,
                    Arrays.asList("DEMOKRATYCZNA REPUBLIKA KONGA", "RWANDA", "TANZANIA", "KENIA"), StanSektoraPanstwa.BARDZO_SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("DEMOKRATYCZNA REPUBLIKA KONGA", 3438, 2034, 101780263,
                    Arrays.asList("ANGOLA", "BURUNDI", "REPUBLIKA ŚRODKOWOAFRYKAŃSKA", "KONGO", "RWANDA", "TANZANIA", "UGANDA", "ZAMBIA"), StanSektoraPanstwa.BARDZO_SLABY, StanSektoraPanstwa.BARDZO_SLABY,
                    false, false),

            new Panstwo("KONGO", 3286, 2000, 5293070,
                    Arrays.asList("GABON", "KAMERUN", "REPUBLIKA ŚRODKOWOAFRYKAŃSKA", "ANGOLA", "DEMOKRATYCZNA REPUBLIKA KONGA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("GABON", 3203, 2003, 1908000,
                    Arrays.asList("GWINEA RÓWNIKOWA", "KAMERUN", "KONGO"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("GWINEA RÓWNIKOWA", 3178, 1957, 1170308,
                    Arrays.asList("KAMERUN", "GABON"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    false, false),

            new Panstwo("RWANDA", 3578, 2036, 11901484,
                    Arrays.asList("BURUNDI", "DEMOKRATYCZNA REPUBLIKA KONGA", "TANZANIA", "UGANDA"), StanSektoraPanstwa.BARDZO_SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("BURUNDI", 3578, 2074, 10867000,
                    Arrays.asList("RWANDA", "TANZANIA", "DEMOKRATYCZNA REPUBLIKA KONGA"), StanSektoraPanstwa.BARDZO_SLABY, StanSektoraPanstwa.BARDZO_SLABY,
                    false, false),

            new Panstwo("TANZANIA", 3671, 2132, 53950935,
                    Arrays.asList("BURUNDI", "KENIA", "MALAWI", "MOZAMBIK", "RWANDA", "UGANDA", "ZAMBIA", "DEMOKRATYCZNA REPUBLIKA KONGA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("ANGOLA", 3321, 2278, 28180000,
                    Arrays.asList("DEMOKRATYCZNA REPUBLIKA KONGA", "NAMIBIA", "KONGO", "ZAMBIA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("ZAMBIA", 3497, 2333, 17238000,
                    Arrays.asList("DEMOKRATYCZNA REPUBLIKA KONGA", "MALAWI", "ZIMBABWE", "TANZANIA", "MOZAMBIK", "NAMIBIA", "BOTSWANA"),
                    StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY, false, false),

            new Panstwo("MALAWI", 3656, 2295, 19169000,
                    Arrays.asList("TANZANIA", "MOZAMBIK", "ZAMBIA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("MOZAMBIK", 3742, 2330, 26573706,
                    Arrays.asList("RPA", "ZIMBABWE", "ZAMBIA", "MALAWI", "TANZANIA", "SUAZI"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("ZIMBABWE", 3568, 2432, 14877000,
                    Arrays.asList("MOZAMBIK", "ZAMBIA", "BOTSWANA", "RPA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("BOTSWANA", 3447, 2503, 2180000,
                    Arrays.asList("RPA", "NAMIBIA", "ZIMBABWE", "ZAMBIA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("NAMIBIA", 3300, 2483, 2484780,
                    Arrays.asList("ANGOLA", "BOTSWANA", "RPA", "ZAMBIA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("RPA", 3413, 2713, 54841552,
                    Arrays.asList("NAMIBIA", "BOTSWANA", "ZIMBABWE", "MOZAMBIK", "SUAZI", "LESOTHO"), StanSektoraPanstwa.SREDNI, StanSektoraPanstwa.SREDNI,
                    true, true),

            new Panstwo("LESOTHO", 3527, 2681, 1942000,
                    Arrays.asList("RPA"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("SUAZI", 3596, 2616, 1467152,
                    Arrays.asList("RPA", "MOZAMBIK"), StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, false),

            new Panstwo("MADAGASKAR", 3909, 2447, 25613000,
                    null, StanSektoraPanstwa.SLABY, StanSektoraPanstwa.SLABY,
                    false, true)
            );

    public List<Panstwo> getPanstwa(){
        return listaPanstw;
    }

}
