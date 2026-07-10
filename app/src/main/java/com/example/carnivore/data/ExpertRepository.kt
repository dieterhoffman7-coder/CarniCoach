package com.example.carnivore.data

object ExpertRepository {

    val experts = listOf(

        Expert(
            id = 1,
            name = "Dr. Ken Berry",
            credentials = "MD, Family Medicine",
            specialty = "Low-carb & carnivore lifestyle for chronic disease",
            bio = "Board-certified family physician with over 20 years of clinical " +
                "experience. Author of \"Lies My Doctor Told Me.\" Focuses on practical, " +
                "no-fluff guidance on low-carb, keto, and carnivore approaches for " +
                "diabetes, obesity, and hormone health.",
            youtubeUrl = "https://www.youtube.com/@KenDBerryMD"
        ),

        Expert(
            id = 2,
            name = "Dr. Anthony Chaffee",
            credentials = "MD",
            specialty = "Nutrition science & performance",
            bio = "Medical doctor and former professional rugby player with a " +
                "background in molecular and cellular biology. Researches species-specific " +
                "nutrition and speaks widely on the role of diet in chronic disease.",
            youtubeUrl = "https://www.youtube.com/channel/UCzoRyR_nlesKZuOlEjWRXQQ"
        ),

        Expert(
            id = 3,
            name = "Dr. Shawn Baker",
            credentials = "MD, Orthopedic Surgery",
            specialty = "Nutritional therapy & athletic performance",
            bio = "Orthopedic surgeon, international speaker, and best-selling author of " +
                "\"The Carnivore Diet.\" A prominent early voice in the carnivore " +
                "community and a master's-level competitive athlete.",
            youtubeUrl = "https://www.youtube.com/@shawnbakermd"
        ),

        Expert(
            id = 4,
            name = "Dr. Paul Saladino",
            credentials = "MD",
            specialty = "Animal-based nutrition",
            bio = "Physician and author of \"The Carnivore Code.\" Popularized nose-to-tail, " +
                "organ-focused eating within the carnivore community. Since around 2020 " +
                "he has followed a broader \"animal-based\" approach that reintroduces some " +
                "fruit and honey rather than a strict carnivore diet.",
            youtubeUrl = "https://www.youtube.com/@Paulsaladinomd"
        )

    )

}
