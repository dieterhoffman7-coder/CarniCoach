package com.example.carnivore.data

object FoodRepository {

    val foods = listOf(

        Food(
            id = 1,
            name = "Ribeye Steak",
            category = "Beef",
            calories = 291,
            protein = 24.0,
            fat = 21.0,
            carbs = 0.0,
            rating = 5,
            beginnerFriendly = true,
            description = "Excellent fatty steak. Perfect for beginners."
        ),

        Food(
            id = 2,
            name = "Ground Beef 80/20",
            category = "Beef",
            calories = 254,
            protein = 17.0,
            fat = 20.0,
            carbs = 0.0,
            rating = 5,
            beginnerFriendly = true,
            description = "One of the best everyday carnivore foods."
        ),

        Food(
            id = 3,
            name = "Eggs",
            category = "Eggs",
            calories = 143,
            protein = 13.0,
            fat = 10.0,
            carbs = 1.1,
            rating = 5,
            beginnerFriendly = true,
            description = "Highly nutritious and versatile."
        ),

        Food(
            id = 4,
            name = "Butter",
            category = "Dairy",
            calories = 717,
            protein = 0.9,
            fat = 81.0,
            carbs = 0.1,
            rating = 5,
            beginnerFriendly = true,
            description = "Excellent source of healthy animal fat."
        ),

        Food(
            id = 5,
            name = "Beef Liver",
            category = "Organ Meat",
            calories = 135,
            protein = 20.0,
            fat = 3.5,
            carbs = 3.9,
            rating = 4,
            beginnerFriendly = false,
            description = "Very nutrient-dense. Best eaten occasionally."
        )

    )

}
