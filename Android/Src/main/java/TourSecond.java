package com.example.user.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Collections;

public class TourSecond extends AppCompatActivity {

    ListView lv;
    String delhi="Delhi  officially the National Capital Territory of Delhi (NCT), is a city and a union territory of India The NCT covers an area of 1,484 square kilometres (573 sq mi). \n" + "Places to visit\n"+"\n"+"India Gate\n" + "Red Fort\n" + "Akshardham\n" + "Jama Masjid\n" + "Sarojni Nagar\n" + "Qutub Minar\n" + "Lotus Temple\n" + "Chandni Chowk\n" + "Hauz Khas\n" + "Kingdom Of Dreams\n" + "Dilli Haat\n"+"Rastrpati Bhawan";
    String wb="Kolkata (formerly Calcutta) is the capital of India's West Bengal state. Founded as an East India Company trading post, it was India's capital under the British Raj from 1773–1911. Today it’s known for its grand colonial architecture, art galleries and cultural festivals.\n" +"Places to visit\n"+
            "Victoria Memorial\n" + "Howrah Bridge\n" + "Dakshineswar Kali Temple\n" + "Indian Museum\n" + "Kalighat Kali Temple\n" + "Nehru Children Museum (Doll House)\n" + "Mother's Wax Museum\n" + "Eco Park\n" + "Science City\n" + "St. Paul's Cathedral\n" + "Kolkata Book Fair ( Jan/Feb)\n" + "Sunderban";
    String mah="Mumbai (formerly called Bombay) is a densely populated city on India’s west coast. A financial center, it's India's largest city. On the Mumbai Harbour waterfront stands the iconic Gateway of India stone arch. The city's also famous as the heart of the Bollywood film industry.\n"+"Places to visit\n" +"Gateway of India\n" + "Elephanta Caves\n" + "Global Vipassana Pagoda\n" + "Khotachiwadi Village\n" + "St. George Fort\n" + "Juhu Beach\n" + "Worli Seaface\n" + "Film City\n" + "Marine Drive";
    String raj="Rajasthan is a northern Indian state bordering Pakistan. Its palaces and forts are reminders of the many kingdoms that historically vied for the region. In its capital, Jaipur (the \"Pink City\"), Udaipur, Jodhpur are many tourist spots.\n" +
            "Places to visit\n" + "Hawa Mahal\n" + "Amer Fort\n" + "Mehranghar Fort\n" + "Jal Mahal\n" + "Jaisalmer\n" + "Lake Pichola\n" + "Mount Abu";
    String guj="Gujarat, India's westernmost state, has varied terrain and numerous sacred sites. In its urban center of Ahmedabad is the Calico Museum of Textiles, displaying antique and modern Indian fabrics. Spiritual leader Mahatma Gandhi's base from 1917–1930 was Sabarmati Ashram, where his living quarters remain on view.\n" + "\n" +"Places to visit\n"+ "Dwarka\n" + "Somnath\n" + "Gir\n" + "Diu\n" +"Surat\n" + "Ahemdabad";

    String assam="Assam  is a state in Northeast India, situated south of the eastern Himalayas along the Brahmaputra and Barak River valleys. The Assamese people traditionally consisted of indigenous ethnic tribes like Koch Rajbongshi . Assam covers an area of 78,438 km2 (30,285 sq mi).  Assam is known for Assam tea and Assam silk "+"\n"+"Places to visit\n"+"Guwahati\n" +
            "Kamakahya Devi Mandir\n" + "Kalakhetra\n" + "Dispur\n" + "Kaziranga National Park\n" + "Sonbil\n" + "Majuli\n" + "Tezpur\n" + "Basistha";
    String kar="Karnataka is a state in the south western region of India. It was formed on 1 November 1956, with the passage of the States Reorganisation Act. Originally known as the State of Mysore, it was renamed Karnataka in 1973.  is the eighth largest state by population, comprising 30 districts .\n" +
            "Places to visit\n" + "Bangalore Palace\n" + "Mysore Palace\n" + "Virupaksha Temple\n" +"Hampi Bazaar\n" + "Lalbagh Garden\n" + "Maderi Fort\n" + "Bandipur National Park\n" + "Chikmagalur";
    String ker="Kerala, a state on India's tropical Malabar Coast, has nearly 600km of Arabian Sea shoreline. It's known for its palm-lined beaches and backwaters, a network of canals. Inland are the Western Ghats, mountains whose slopes support tea, coffee and spice plantations as well as wildlife. National parks like Eravikulam and Periyar.\n" +
            "Places to visit\n" + "Paradesi Synagouge\n" + "Fort Kochi\n" + "Allepy\n" + "Munnar\n" + "Thekkady\n" + "Vemabanad\n" + "Marari Beach\n" + "Pathiramanal";
    String miz="Mizoram is a state in Northeast India, with Aizawl as its capital city. The name is derived from \"Mizo\", the name of the native inhabitants, and \"Ram\", which means land, and thus Mizoram means \"land of the Mizos\".Within the northeast region, it is the southernmost landlocked state, sharing borders with three of the Seven Sister States, namely Tripura, Assam and Manipur. The state also shares a 722 kilometre border with the neighbouring countries of Bangladesh and Myanmar.\n" +
            "\n" + "Places to visit\n" +  "\n" +   "Reiek\n" +      "Tam Dil\n" +  "Murlen National Park\n" + "Phawngpui National Park\n" +
            "Lushai Hills\n" + "Mizoram State Museum\n" +  "Nagaland\n" +
            "Aizawl\n" +
            "Lungei\n" +
            "Kolasib\n" +
            "Thenzawl\n" +
            "Serchhip\n" +
            "Champai";
    String ta="Tamil Nadu lies in the southernmost part of the Indian Peninsula .The state shares a maritime border with the nation of Sri Lanka. Tamil Nadu is the eleventh-largest state in India by area and the sixth-most populous. The state was ranked third among states in India according to the Human Development Index in 2015, and is the second-largest state economy in India with ₹15.96 lakh crore(US$240 billion) in gross domestic product after Maharashtra.\n" +
            "\n" +
            "Places to visit\n" +
            "\n" +
            "Pondicherry\n" +
            "Sri Aurobindo Ashram\n" +
            "Promenade Beach\n" +
            "Arulmigu Manakula Vinaynagar Temple\n" +
            "Rock Beach\n" +
            "Bharati Park\n" +
            "Matrimandir\n" +
            "Auroville Beach\n" +
            "Ariyankuppam\n" +
            "Kalapet\n";
    String mp="Madhya Pradesh, a large state in central India, retains landmarks from eras throughout Indian history. Begun in the 10th century, its Hindu and Jain temples at Khajuraho are renowned for their carvings of erotic scenes, most prominently Kandariya Mahadeva, a temple with more than 800 sculptures.\n" +
            "\n" +
            "Places to visit\n" +
            "\n" +
            "Kanha Tiger Reserve\n" +
            "Gwalior Fort\n" +
            "Kandariya Mahadev Temple\n" + "Bhimbetka Rock Shelter\n" +
            "Panna National Park\n" +
            "Omkareshwar\n" +
            "Magical Mandu\n" +
            "Sachi Stupa\n" +
            "Ujjain\n" +
            "Jabalpur\n" +
            "Baghin Nala";
    String ka="Jammu and Kashmir is a state in northern India, often denoted by its acronym, J&K. It is located mostly in the Himalayanmountains.The Line of Control separates it from the Pakistani-administered territories of Azad Kashmir and Gilgit-Baltistan in the west and north respectively, and a Line of Actual Control separates it from the Chinese-administered territory of Aksai Chin in the east. \n" +
            "\n" +
            "Places to visit\n" +
            "\n" +
            "Pangong Tao\n" +
            "Jammu\n" +
            "Zanskar\n" +
            "Nyak Tso\n" +
            "Samba\n" +
            "Khardong,Leh\n" +
            "Ramban\n" +
            "Ranjit Sagar Dam Lake\n" +
            "Dal lake\n" +
            "Gadsar Lake\n" +
            "Anchar Lake";
    /*

   int[] delhi={R.drawable.d1,R.drawable.d2};
   int[] wb={R.drawable.wb1,R.drawable.wb2};
   int[] mah={};
   int[] raj={};
    int[] guj={};
    int[] assam={};
    int[] kar={};
    int[] ker={};
    int[] miz={}
    int[]
    int[] int[]

    */


    String[] stateDesc={delhi,wb,mah,raj,assam,guj,kar,ker,miz,ta,mp,ka};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_second);
        lv = (ListView) findViewById(R.id.idListView);
        int pos;
        pos=getIntent().getExtras().getInt("image");
        String s=stateDesc[pos];

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, Collections.singletonList(s));
        lv.setAdapter(adapter);
        //Setting onClickListener on ListView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }
}

