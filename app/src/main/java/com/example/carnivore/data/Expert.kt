package com.example.carnivore.data

data class FeaturedVideo(
    val title: String,
    val url: String
)

data class Expert(
    val id: Int,
    val name: String,
    val credentials: String,
    val specialty: String,
    val bio: String,
    val youtubeUrl: String,
    val featuredVideos: List<FeaturedVideo> = emptyList()
)
