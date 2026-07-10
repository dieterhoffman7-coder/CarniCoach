package com.example.carnivore.data

object KnowledgeRepository {

    val knowledge = listOf(

        Knowledge(
            id = 1,
            title = "Electrolytes",
            category = "Beginner",
            summary = "Electrolytes are one of the most important parts of adapting to carnivore.",
            beginnerText = "During the first weeks your body loses water and sodium as glycogen stores are depleted and insulin levels fall. Staying hydrated and maintaining electrolytes can help reduce headaches, fatigue and muscle cramps.",
            advancedText = "Lower insulin reduces renal sodium retention. Glycogen depletion also releases stored water, increasing urinary fluid loss. Individual electrolyte needs vary, and people with kidney disease or certain medications should seek medical advice before supplementing.",
            evidenceLevel = "Clinical + Scientific",
            relatedLessons = listOf(1)
        ),

        Knowledge(
            id = 2,
            title = "Fat",
            category = "Fundamentals",
            summary = "Fat is the primary energy source on a carnivore diet, replacing carbohydrates.",
            beginnerText = "Dietary fat becomes your main fuel source. Fattier cuts of meat help you feel satisfied and provide steady energy without the blood sugar swings of carbohydrates.",
            advancedText = "Fat oxidation and ketone production increase as carbohydrate intake drops. Dietary fat quality and ratio to protein both influence satiety and metabolic adaptation, though individual needs vary widely.",
            evidenceLevel = "Scientific",
            relatedLessons = emptyList()
        ),

        Knowledge(
            id = 3,
            title = "Protein",
            category = "Fundamentals",
            summary = "Protein supports muscle maintenance, satiety, and overall recovery.",
            beginnerText = "Meat, eggs, and fish provide complete protein with all essential amino acids. Eating enough protein helps preserve muscle, especially during weight loss.",
            advancedText = "Protein has a higher thermic effect than fat or carbohydrate and stimulates muscle protein synthesis via leucine-driven mTOR activation. Optimal intake depends on body composition goals and activity level.",
            evidenceLevel = "Scientific",
            relatedLessons = emptyList()
        ),

        Knowledge(
            id = 4,
            title = "Ketosis",
            category = "Fundamentals",
            summary = "Ketosis is a metabolic state where the body burns fat for fuel and produces ketones.",
            beginnerText = "When carbohydrate intake is very low, your liver converts fat into ketones, which your brain and body can use for energy instead of glucose.",
            advancedText = "Nutritional ketosis is typically defined as blood beta-hydroxybutyrate above roughly 0.5 mmol/L. It differs from diabetic ketoacidosis, which involves uncontrolled, dangerously high ketone levels alongside high blood sugar.",
            evidenceLevel = "Scientific",
            relatedLessons = emptyList()
        ),

        Knowledge(
            id = 5,
            title = "Fasting",
            category = "Tools",
            summary = "Intermittent or extended fasting can pair naturally with carnivore eating.",
            beginnerText = "Many carnivore eaters naturally eat fewer times per day due to increased satiety, which can lead to intermittent fasting without much effort.",
            advancedText = "Fasting extends the metabolic state already promoted by very low-carbohydrate eating, further increasing fat oxidation and ketone production. Extended fasts should be approached cautiously and are not appropriate for everyone.",
            evidenceLevel = "Scientific",
            relatedLessons = emptyList()
        ),

        Knowledge(
            id = 6,
            title = "Weight Loss",
            category = "Goals",
            summary = "Weight loss on carnivore is typically driven by increased satiety and reduced calorie intake.",
            beginnerText = "Eating high-protein, high-fat meals tends to be very filling, which naturally reduces how much you eat without needing to consciously restrict.",
            advancedText = "Reduced insulin, improved satiety signaling from protein and fat, and elimination of highly palatable processed foods are the main proposed mechanisms behind spontaneous calorie reduction on carnivore.",
            evidenceLevel = "Clinical + Scientific",
            relatedLessons = emptyList()
        ),

        Knowledge(
            id = 7,
            title = "Exercise",
            category = "Lifestyle",
            summary = "Exercise performance can shift during the adaptation period before stabilizing.",
            beginnerText = "You may notice reduced high-intensity performance for the first few weeks as your body adapts to using fat for fuel. Endurance activities often adapt well over time.",
            advancedText = "Glycolytic, high-intensity efforts rely more on carbohydrate availability, while fat-adapted athletes often show comparable or improved performance in sustained aerobic efforts after an adaptation period of several weeks.",
            evidenceLevel = "Scientific",
            relatedLessons = emptyList()
        ),

        Knowledge(
            id = 8,
            title = "Inflammation",
            category = "Health",
            summary = "Many people report reduced joint pain and inflammation on a carnivore diet.",
            beginnerText = "Removing common plant compounds like lectins and oxalates, alongside cutting processed foods and sugar, is often reported to reduce joint pain and skin issues.",
            advancedText = "Mechanisms proposed include reduced intake of pro-inflammatory seed oils, elimination of specific plant antinutrients, and improved glycemic control. High-quality long-term trial data specific to carnivore diets remains limited.",
            evidenceLevel = "Anecdotal + Early Research",
            relatedLessons = emptyList()
        ),

        Knowledge(
            id = 9,
            title = "Cholesterol",
            category = "Health",
            summary = "Cholesterol often rises on carnivore, which can look concerning without proper context.",
            beginnerText = "LDL cholesterol frequently increases on a high-fat carnivore diet. This is an active area of debate, and it's worth discussing your individual bloodwork with a doctor familiar with low-carb diets.",
            advancedText = "Some individuals — often lean, metabolically healthy people on very low-carb diets — show a pattern of significantly elevated LDL alongside high HDL and low triglycerides, sometimes called a 'lean mass hyper-responder' phenotype. Long-term cardiovascular outcome data for this specific pattern is still limited, so individualized monitoring is recommended.",
            evidenceLevel = "Scientific + Debated",
            relatedLessons = emptyList()
        ),

        Knowledge(
            id = 10,
            title = "Common Mistakes",
            category = "Beginner",
            summary = "A few avoidable mistakes account for most early struggles on carnivore.",
            beginnerText = "The most common early mistakes are eating too lean (not enough fat), under-salting food, not drinking enough water, and giving up during the first 1-2 weeks before adaptation symptoms resolve.",
            advancedText = "Insufficient fat intake leads to low energy availability and poor satiety, while inadequate sodium replacement drives most of the classic 'keto flu' symptoms. Consistency through the adaptation window is the single biggest predictor of long-term success.",
            evidenceLevel = "Clinical",
            relatedLessons = listOf(1)
        )

    )

}
