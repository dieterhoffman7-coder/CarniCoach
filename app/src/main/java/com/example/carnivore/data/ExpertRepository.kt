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
            youtubeUrl = "https://www.youtube.com/@KenDBerryMD",
            featuredVideos = listOf(
                FeaturedVideo(
                    title = "Carnivore Diet FAQ for Beginners - 33 Common Questions Answered",
                    url = "https://youtu.be/t2om-RJbLyg"
                )
            )
        ),

        Expert(
            id = 2,
            name = "Dr. Anthony Chaffee",
            credentials = "MD",
            specialty = "Nutrition science & performance",
            bio = "Medical doctor and former professional rugby player with a " +
                "background in molecular and cellular biology. Researches species-specific " +
                "nutrition and speaks widely on the role of diet in chronic disease.",
            youtubeUrl = "https://www.youtube.com/channel/UCzoRyR_nlesKZuOlEjWRXQQ",
            featuredVideos = listOf(
                FeaturedVideo(
                    title = "Carnivore For Beginners: How To Start A Carnivore Diet " +
                        "with Tips, Tricks, and Common Pitfalls",
                    url = "https://youtu.be/V8ns1j28vhc"
                )
            )
        ),

        Expert(
            id = 3,
            name = "Dr. Shawn Baker",
            credentials = "MD, Orthopedic Surgery",
            specialty = "Nutritional therapy & athletic performance",
            bio = "Orthopedic surgeon, international speaker, and best-selling author of " +
                "\"The Carnivore Diet.\" A prominent early voice in the carnivore " +
                "community and a master's-level competitive athlete.",
            youtubeUrl = "https://www.youtube.com/@shawnbakermd",
            featuredVideos = listOf(
                FeaturedVideo(
                    title = "How To Get Started on a Carnivore Diet",
                    url = "https://youtu.be/SgDiSbiQv9A"
                )
            )
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
        ),

        Expert(
            id = 5,
            name = "Dr. Eric Westman",
            credentials = "MD, MHS",
            specialty = "Low-carb/keto & carnivore metabolic health",
            bio = "Associate Professor of Medicine at Duke University, board certified in " +
                "Obesity Medicine and Internal Medicine, and founder of the Duke Keto " +
                "Medicine Clinic. Over 25 years of clinical research on low-carb and " +
                "ketogenic diets. Author of \"The New Atkins for a New You,\" \"Keto " +
                "Clarity,\" and \"Cholesterol Clarity,\" and co-founder of Adapt Your Life " +
                "Academy.",
            youtubeUrl = "https://www.youtube.com/channel/UCni9TCw0YPwTdu7BYF3j0Eg",
            featuredVideos = listOf(
                FeaturedVideo(
                    title = "How To Start Carnivore Right In 2026 - Avoid These Mistakes",
                    url = "https://youtu.be/vCpWIf27vdU"
                )
            )
        ),

        Expert(
            id = 6,
            name = "Kerry Mann Jr.",
            credentials = "Health Advocate & Documentary Filmmaker",
            specialty = "Personal carnivore transformation & community advocacy",
            bio = "Homesteader and creator of the YouTube channel HomeSteadHow (~369K " +
                "subscribers). Reversed congestive heart failure, IBS, gout, and obesity - " +
                "losing over 100 lbs - after adopting a carnivore \"proper human diet\" in " +
                "2023. Now producing the documentary \"Healing Humanity: The Power of a " +
                "Proper Human Diet,\" featuring interviews with doctors who practice " +
                "carnivore themselves. Not a medical professional - shares a personal " +
                "advocacy perspective rather than clinical guidance.",
            youtubeUrl = "https://www.youtube.com/@Homesteadhow",
            featuredVideos = listOf(
                FeaturedVideo(
                    title = "The Best Way To Start Carnivore Diet",
                    url = "https://youtu.be/w_zzvm4vU2Y"
                ),
                FeaturedVideo(
                    title = "Healing Humanity: Community, Food & Resilience",
                    url = "https://youtu.be/ohHyIhl55j0"
                )
            )
        ),

        Expert(
            id = 7,
            name = "Adam Lacy",
            credentials = "Health Advocate & Documentary Filmmaker",
            specialty = "Personal carnivore transformation, community & storytelling",
            bio = "Professional photographer (Sports Illustrated, National Geographic, " +
                "ESPN) turned carnivore advocate. Reversed vitiligo, a six-year-old " +
                "traumatic brain injury from a car accident, and depression/anxiety after " +
                "going carnivore. Assistant director of the \"Healing Humanity\" " +
                "documentary alongside Kerry Mann Jr., and host of the Carnivore Today " +
                "podcast/YouTube channel. Not a medical professional - shares a personal " +
                "advocacy perspective rather than clinical guidance.",
            youtubeUrl = "https://www.youtube.com/@CarnivoreToday",
            featuredVideos = listOf(
                FeaturedVideo(
                    title = "Healing Humanity: Community, Food & Resilience",
                    url = "https://youtu.be/ohHyIhl55j0"
                )
            )
        ),

        Expert(
            id = 8,
            name = "Max German",
            credentials = "Content Creator, Biology Student",
            specialty = "Practical carnivore troubleshooting for beginners",
            bio = "New Zealand-based creator and biology student with about 9 years of " +
                "study focused on human health and nutrition. Started carnivore in his " +
                "teens after struggling with IBS. Runs a YouTube channel and podcast " +
                "focused on evidence-informed, practical carnivore guidance and " +
                "mistake-avoidance. Not a medical professional - shares a personal and " +
                "research-informed perspective rather than clinical guidance.",
            youtubeUrl = "https://www.youtube.com/@max.german",
            featuredVideos = listOf(
                FeaturedVideo(
                    title = "STOP Doing THIS! It's The FASTEST Way To Ruin Carnivore Results",
                    url = "https://youtu.be/GyOQiuIKf0I"
                )
            )
        )

    )

}
