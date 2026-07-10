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
        )

    )

}
