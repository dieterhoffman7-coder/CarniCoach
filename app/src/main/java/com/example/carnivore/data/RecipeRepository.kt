package com.example.carnivore.data

object RecipeRepository {

    val recipes = listOf(

        Recipe(
            id = 1,
            name = "Classic Ribeye",
            emoji = "🥩",
            prepTimeMinutes = 15,
            servings = 1,
            ingredients = listOf(
                "1 ribeye steak (250-300g)",
                "Salt, to taste",
                "1 tbsp butter or tallow"
            ),
            steps = listOf(
                "Take the steak out of the fridge 30 minutes before cooking to come to room temperature.",
                "Pat dry and season generously with salt on both sides.",
                "Heat a heavy skillet until very hot, add the fat.",
                "Sear 3-4 minutes per side for medium-rare, adjusting to your thickness and preference.",
                "Rest for 5 minutes before slicing."
            )
        ),

        Recipe(
            id = 2,
            name = "Simple Ground Beef Skillet",
            emoji = "🍳",
            prepTimeMinutes = 15,
            servings = 2,
            ingredients = listOf(
                "500g ground beef (80/20)",
                "Salt, to taste",
                "3 large eggs (optional, cooked on top)"
            ),
            steps = listOf(
                "Heat a skillet over medium-high heat, no extra fat needed.",
                "Add ground beef, breaking it up as it browns.",
                "Season with salt and cook until no pink remains, about 8-10 minutes.",
                "Optionally push beef aside and fry eggs in the rendered fat.",
                "Serve together."
            )
        ),

        Recipe(
            id = 3,
            name = "Salmon with Butter",
            emoji = "🐟",
            prepTimeMinutes = 15,
            servings = 1,
            ingredients = listOf(
                "1 salmon fillet (150-200g)",
                "Salt, to taste",
                "1 tbsp butter"
            ),
            steps = listOf(
                "Pat the salmon dry and season with salt.",
                "Heat a pan over medium heat and melt the butter.",
                "Place salmon skin-side down and cook 4-5 minutes.",
                "Flip and cook another 2-3 minutes until just cooked through.",
                "Spoon the browned butter over before serving."
            )
        ),

        Recipe(
            id = 4,
            name = "Slow Cooker Beef Chuck Roast",
            emoji = "🍲",
            prepTimeMinutes = 10,
            servings = 4,
            ingredients = listOf(
                "1.5kg beef chuck roast",
                "2 tsp salt",
                "1 cup beef bone broth (optional, for moisture)"
            ),
            steps = listOf(
                "Season the roast generously with salt on all sides.",
                "Place in a slow cooker with the broth.",
                "Cook on low for 8 hours, or until fork-tender.",
                "Shred or slice, spoon some of the cooking liquid over before serving."
            )
        ),

        Recipe(
            id = 5,
            name = "Bacon and Eggs",
            emoji = "🥓",
            prepTimeMinutes = 10,
            servings = 1,
            ingredients = listOf(
                "4 strips bacon",
                "3 large eggs",
                "Salt, to taste"
            ),
            steps = listOf(
                "Cook bacon in a skillet over medium heat until crisp, about 6-8 minutes.",
                "Remove bacon, leaving the rendered fat in the pan.",
                "Crack eggs into the same pan and cook to your preference.",
                "Season with salt and serve together."
            )
        ),

        Recipe(
            id = 6,
            name = "Pan-Seared Lamb Chops",
            emoji = "🍖",
            prepTimeMinutes = 15,
            servings = 2,
            ingredients = listOf(
                "4 lamb chops",
                "Salt, to taste",
                "1 tbsp tallow or butter"
            ),
            steps = listOf(
                "Season lamb chops generously with salt.",
                "Heat a skillet until very hot, add the fat.",
                "Sear 2-3 minutes per side for medium-rare.",
                "Rest for 5 minutes before serving."
            )
        )

    )

}
