package com.example.carnivore.data

object SymptomRepository {

    val symptoms = listOf(

        Symptom(
            id = 1,
            name = "Headache",
            emoji = "🤕",
            commonCause = "Low sodium and fluid intake as glycogen and its stored water are depleted.",
            recommendedAction = "Add extra salt to food or water, and make sure you're drinking enough fluids."
        ),

        Symptom(
            id = 2,
            name = "Fatigue",
            emoji = "😴",
            commonCause = "Your body is shifting from burning carbohydrates to burning fat and ketones for fuel.",
            recommendedAction = "Ensure adequate salt and calorie intake, and give it 1-2 weeks for energy to stabilize."
        ),

        Symptom(
            id = 3,
            name = "Cravings",
            emoji = "🍬",
            commonCause = "Habitual eating patterns and blood sugar swings from prior carb intake.",
            recommendedAction = "Eat enough fat and protein to reach satiety, and stay consistent — cravings usually fade within 1-3 weeks."
        ),

        Symptom(
            id = 4,
            name = "Diarrhea",
            emoji = "💩",
            commonCause = "The gut adjusting to a much higher fat intake and different digestive demands.",
            recommendedAction = "Give it time to settle, avoid excess dairy if it seems to trigger symptoms, and stay hydrated."
        ),

        Symptom(
            id = 5,
            name = "Constipation",
            emoji = "🚫",
            commonCause = "Lower stool volume from eating very low-fiber foods, and possible dehydration.",
            recommendedAction = "Make sure you're drinking enough water and getting adequate salt and magnesium; this often improves as your gut adapts."
        ),

        Symptom(
            id = 6,
            name = "Muscle Cramps",
            emoji = "🦵",
            commonCause = "Low magnesium and potassium, common when sodium and water losses aren't replaced.",
            recommendedAction = "Focus on electrolyte-rich foods and consider a magnesium supplement if cramps persist."
        ),

        Symptom(
            id = 7,
            name = "Bad Breath",
            emoji = "😮",
            commonCause = "A byproduct of ketosis — your body producing and exhaling ketones like acetone.",
            recommendedAction = "This is usually temporary as your body adapts. Staying well hydrated can help reduce it."
        ),

        Symptom(
            id = 8,
            name = "Poor Sleep",
            emoji = "🌙",
            commonCause = "Shifts in cortisol and electrolyte balance during the adaptation period.",
            recommendedAction = "Keep a consistent sleep schedule, ensure adequate salt and magnesium, and avoid eating very late if it disrupts sleep."
        )

    )

}
