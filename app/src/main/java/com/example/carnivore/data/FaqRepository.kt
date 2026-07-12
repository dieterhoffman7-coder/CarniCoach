package com.example.carnivore.data

object FaqRepository {

    val faqs = listOf(

        Faq(
            id = 1,
            question = "Is diarrhea normal when starting carnivore?",
            answer = "Yes, loose stools are common in the first 1-2 weeks as your gut " +
                "adapts to a very different fiber and fat intake. It usually settles as " +
                "your body adjusts. If it persists beyond a few weeks or is severe, check " +
                "with a doctor.",
            category = "Adaptation"
        ),

        Faq(
            id = 2,
            question = "Why do I have headaches?",
            answer = "Headaches in the first days are usually linked to low sodium and " +
                "water intake as your body sheds glycogen and its associated water. " +
                "Adding extra salt and staying hydrated resolves this for most people.",
            category = "Adaptation"
        ),

        Faq(
            id = 3,
            question = "Why am I tired?",
            answer = "Fatigue during the first 1-2 weeks is often part of \"keto flu\" as " +
                "your body shifts from burning carbs to burning fat and ketones for fuel. " +
                "Adequate salt, water, and not restricting calories too aggressively " +
                "usually helps energy recover.",
            category = "Adaptation"
        ),

        Faq(
            id = 4,
            question = "Why am I gaining weight instead of losing it?",
            answer = "Early water retention, adjusting portion sizes, or eating more " +
                "calories than you need can all cause this. Give it a few weeks, track " +
                "your intake if needed, and focus on eating to satiety rather than " +
                "overeating out of habit.",
            category = "Weight"
        ),

        Faq(
            id = 5,
            question = "How much fat should I eat?",
            answer = "Most people eat fattier cuts of meat and let hunger guide portion " +
                "size rather than counting exact grams. As a rough starting point, many " +
                "aim for a ratio of roughly 70-80% of calories from fat, adjusting to " +
                "appetite and goals.",
            category = "Nutrition"
        ),

        Faq(
            id = 6,
            question = "Can I drink coffee on carnivore?",
            answer = "Coffee is plant-derived, so strict carnivore excludes it, but many " +
                "people include it and do fine. If you're troubleshooting symptoms, " +
                "temporarily removing coffee can help you see if it's a contributing " +
                "factor.",
            category = "Foods & Drinks"
        ),

        Faq(
            id = 7,
            question = "Can I eat dairy on carnivore?",
            answer = "Dairy is commonly included, especially hard cheeses and heavy " +
                "cream, but some people are sensitive to it. If you have digestive " +
                "symptoms, try removing dairy for 2-3 weeks and reintroducing it to see " +
                "how you respond.",
            category = "Foods & Drinks"
        ),

        Faq(
            id = 8,
            question = "Are eggs part of carnivore?",
            answer = "Yes, eggs are a staple carnivore food and a good source of protein, " +
                "fat, and micronutrients like choline. Most carnivore approaches include " +
                "them freely.",
            category = "Foods & Drinks"
        ),

        Faq(
            id = 9,
            question = "How much salt should I use?",
            answer = "Salt needs go up on carnivore because insulin drops and the kidneys " +
                "excrete more sodium. Salting food to taste, rather than avoiding it, is " +
                "the general guidance — most people need noticeably more salt than they " +
                "did eating a standard diet.",
            category = "Nutrition"
        ),

        Faq(
            id = 10,
            question = "Should I count calories on carnivore?",
            answer = "Most people don't count calories and instead eat until comfortably " +
                "full, relying on the diet's natural appetite-regulating effect. Counting " +
                "can be useful short-term if weight loss stalls, but it isn't required.",
            category = "Nutrition"
        ),

        Faq(
            id = 11,
            question = "What mistakes do carnivore beginners make?",
            answer = "The most common pitfalls are under-eating (not eating to satiety, " +
                "which leads to fatigue), under-salting (this diet has almost no sodium " +
                "unless you add it), and quitting during the adaptation period instead of " +
                "pushing through the first 1-2 weeks. Going too lean instead of eating " +
                "enough fat is also one of the biggest early mistakes.",
            category = "Adaptation",
            source = "Dr. Anthony Chaffee"
        ),

        Faq(
            id = 12,
            question = "Can I still exercise on carnivore?",
            answer = "Yes - many people find their strength and recovery improve once " +
                "fully fat-adapted, though the first couple of weeks can feel low-energy " +
                "as your body shifts from burning carbs to burning fat. Keep workouts " +
                "lighter during that adaptation window, stay salted and hydrated, and " +
                "ramp back up as energy returns.",
            category = "Exercise & Lifestyle",
            source = "Dr. Anthony Chaffee"
        ),

        Faq(
            id = 13,
            question = "Do I need vitamin D3 on carnivore?",
            answer = "Animal fats and butter naturally contain some vitamin D, but if " +
                "your levels are still low (get tested if unsure), a D3 supplement - not " +
                "D2 - is worth considering, since D2 is plant-derived and less effective " +
                "for humans.",
            category = "Nutrition",
            source = "Dr. Anthony Chaffee"
        ),

        Faq(
            id = 14,
            question = "What's the #1 mistake beginners make on carnivore?",
            answer = "Electrolyte imbalance - specifically under-salting. When you cut " +
                "carbs, insulin drops and your kidneys excrete more sodium, so your salt " +
                "needs go up sharply. Many of the headaches, cramps, and fatigue people " +
                "blame on the diet itself are really just a sodium gap.",
            category = "Adaptation",
            source = "Dr. Eric Westman"
        ),

        Faq(
            id = 15,
            question = "Is it normal to feel worse before I feel better?",
            answer = "Yes - the first 1-2 weeks are an adaptation window, sometimes " +
                "called \"keto flu,\" as your body shifts from burning glucose to burning " +
                "fat and ketones. Headaches, low energy, and sugar cravings are common. If " +
                "you're also cutting caffeine at the same time, withdrawal can add to it - " +
                "consider keeping coffee steady while you adapt if it helps.",
            category = "Adaptation",
            source = "Dr. Eric Westman"
        ),

        Faq(
            id = 16,
            question = "Should I be careful about anything before starting?",
            answer = "If you take medication for diabetes or high blood pressure, talk to " +
                "your doctor first. Carnivore can lower blood sugar and blood pressure " +
                "quickly, and dosages that worked on your old diet may need to be adjusted " +
                "soon after you start.",
            category = "Adaptation",
            source = "Dr. Eric Westman"
        ),

        Faq(
            id = 17,
            question = "Do I need to be sick to try carnivore?",
            answer = "No. Some people, like Kerry Mann Jr., come to carnivore after " +
                "serious health struggles and see it as part of reversing those " +
                "conditions, but plenty of people try it simply to simplify their eating " +
                "and see how they feel. You don't need a diagnosis to give it a try.",
            category = "Getting Started",
            source = "Kerry Mann Jr."
        ),

        Faq(
            id = 18,
            question = "What should my first meals look like?",
            answer = "Keep it simple - fatty cuts of beef (ribeyes are a favorite " +
                "starting point), plus salt and water. Prioritizing accessible cuts over " +
                "\"nose-to-tail\" perfection makes it easier to actually stick with.",
            category = "Getting Started",
            source = "Dr. Shawn Baker"
        ),

        Faq(
            id = 19,
            question = "How long does full adaptation take?",
            answer = "The rough carnivore-flu window is the first 1-2 weeks, but full " +
                "metabolic adaptation can take 30-90 days for some people - don't judge " +
                "the diet by week one.",
            category = "Adaptation",
            source = "Dr. Shawn Baker"
        ),

        Faq(
            id = 20,
            question = "I'm eating very lean meat and feel awful - why?",
            answer = "Going too lean (skipping the fat) is a common mistake; eating " +
                "enough fat alongside protein is what actually sustains energy and " +
                "avoids digestive distress.",
            category = "Nutrition",
            source = "Dr. Shawn Baker"
        ),

        Faq(
            id = 21,
            question = "Will carnivore make me constipated without fiber?",
            answer = "There's no physiological requirement for fiber to have normal " +
                "bowel movements; many people report fewer digestive issues on carnivore " +
                "than on high-fiber diets, since fiber itself can be irritating to some " +
                "guts.",
            category = "Adaptation",
            source = "Dr. Ken Berry"
        ),

        Faq(
            id = 22,
            question = "Why is my digestion off in the first few weeks?",
            answer = "Your stomach acid, bile production, and gallbladder function all " +
                "have to upregulate to handle more fat and protein after years on a " +
                "lower-fat diet - that adjustment period can cause temporary loose " +
                "stools, and it settles as your body catches up.",
            category = "Adaptation",
            source = "Dr. Ken Berry"
        ),

        Faq(
            id = 23,
            question = "Will carnivore raise my cholesterol and hurt my heart?",
            answer = "This is contested - Dr. Berry's position is that no study has " +
                "conclusively shown red meat or saturated fat causes heart disease, but " +
                "mainstream cardiology guidance still flags LDL/saturated fat as a risk " +
                "factor. Worth tracking your own lipid panel and talking to your doctor " +
                "rather than assuming either way.",
            category = "Nutrition",
            source = "Dr. Ken Berry"
        ),

        Faq(
            id = 24,
            question = "Is community important for sticking with carnivore?",
            answer = "Both Kerry Mann and Adam Lacy point to community as a major " +
                "factor in long-term success - having other people to share the journey " +
                "with makes the social friction (family questions, eating out, etc.) " +
                "much easier to push through than doing it alone.",
            category = "Getting Started",
            source = "Kerry Mann Jr. & Adam Lacy"
        ),

        Faq(
            id = 25,
            question = "Why do I feel worse the longer I stay on carnivore?",
            answer = "Often it's under-fueling: eating too lean starves your main fuel " +
                "source (fat) even while you're still losing weight short-term, which " +
                "eventually shows up as fatigue and cravings.",
            category = "Adaptation",
            source = "Max German"
        ),

        Faq(
            id = 26,
            question = "Why do my cravings keep coming back?",
            answer = "Cravings are usually a signal you're under-salted or under-fed, " +
                "not a willpower problem - treat them as a troubleshooting cue rather " +
                "than something to white-knuckle through.",
            category = "Adaptation",
            source = "Max German"
        ),

        Faq(
            id = 27,
            question = "Does the type of meat matter?",
            answer = "Many long-term carnivores gravitate toward ruminant meat (beef, " +
                "lamb) specifically because it tends to feel more stable - aiming for at " +
                "least one ruminant-based meal a day is a common baseline.",
            category = "Nutrition",
            source = "Max German"
        )

    )

}
