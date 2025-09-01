package com.example.simpleshop

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import simpleshop.composeapp.generated.resources.Res
import simpleshop.composeapp.generated.resources.*

@Composable
@Preview
fun App() {
    MaterialTheme {
        DiscoverScreen()
    }
}

@Composable
fun DiscoverScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Status Bar
        StatusBar()
        
        // Header
        Header()
        
        // Search Bar
        SearchBar()
        
        // Category Cards
        CategoryCards()
        
        Spacer(modifier = Modifier.weight(1f))
        
        // Bottom Tab Bar
        BottomTabBar()
    }
}

@Composable
fun StatusBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 13.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "9:41",
            fontSize = 15.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )
        
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Cellular signal indicator
            Image(
                painter = painterResource(Res.drawable.ic_cellular),
                contentDescription = "Cellular",
                modifier = Modifier.size(18.dp)
            )
            // WiFi signal indicator  
            Image(
                painter = painterResource(Res.drawable.ic_wifi),
                contentDescription = "WiFi",
                modifier = Modifier.size(16.dp)
            )
            // Battery indicator
            Image(
                painter = painterResource(Res.drawable.ic_battery),
                contentDescription = "Battery",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 31.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_menu),
            contentDescription = "Menu",
            tint = Color.Black,
            modifier = Modifier.size(18.dp)
        )
        
        Text(
            text = "Discover",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        
        Box {
            Icon(
                painter = painterResource(Res.drawable.ic_notification),
                contentDescription = "Notifications",
                tint = Color.Black,
                modifier = Modifier.size(26.dp)
            )
        }
    }
}

@Composable
fun SearchBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 33.dp, vertical = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .height(46.dp)
                .background(Color(0xFFFAFAFA), RoundedCornerShape(20.dp))
                .padding(horizontal = 16.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Icon(
                    painter = painterResource(Res.drawable.ic_search),
                    contentDescription = "Search",
                    tint = Color(0xFF777E90),
                    modifier = Modifier.size(17.dp)
                )
                Text(
                    text = "Search",
                    fontSize = 14.sp,
                    color = Color(0xFF777E90)
                )
            }
        }
        
        Box(
            modifier = Modifier
                .size(49.dp)
                .background(Color(0xFFFAFAFA), RoundedCornerShape(15.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(Res.drawable.ic_filter),
                contentDescription = "Filter",
                tint = Color(0xFF777E90),
                modifier = Modifier.size(27.dp)
            )
        }
    }
}

@Composable
fun CategoryCards() {
    LazyColumn(
        modifier = Modifier.padding(horizontal = 31.dp),
        verticalArrangement = Arrangement.spacedBy(19.dp)
    ) {
        item {
            CategoryCard(
                title = "CLOTHING",
                backgroundColor = Color(0xFFA3A798),
                textColor = Color.White,
                imageDescription = "Floral dress and woven bag",
                imageSize= DpSize(149.dp, 126.dp)
            )
        }
        item {
            CategoryCard(
                title = "ACCESSORIES",
                backgroundColor = Color(0xFF898280),
                textColor = Color.White,
                imageDescription = "Grey handbag and jewelry",
                imageSize= DpSize(151.dp, 106.dp)
            )
        }
        item {
            CategoryCard(
                title = "SHOES",
                backgroundColor = Color(0xFF44565C),
                textColor = Color.White,
                imageDescription = "Black high heels",
                imageSize= DpSize(109.dp, 125.dp),
            )
        }
        item {
            CategoryCard(
                title = "SHOES",
                backgroundColor = Color(0xFFB9AEB2),
                textColor = Color.White,
                imageDescription = "Beige blazer and coat",
                imageSize= DpSize(100.dp, 125.dp)
            )
        }
    }
}

@Composable
fun CategoryCard(
    title: String,
    backgroundColor: Color,
    textColor: Color,
    imageDescription: String,
    imageSize: DpSize
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(125.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(backgroundColor)
    ) {
        // Category title - positioned in lower left as in design
        Text(
            text = title,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            color = textColor,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .alpha(0f)
                .padding(start = 22.dp, bottom = 28.dp)
        )
        
        // Large background circle - positioned further right and larger
        Box(
            modifier = Modifier
                .size(105.dp)
                .align(Alignment.CenterEnd)
                .offset(x = (-40).dp, y = (-10).dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        backgroundColor.copy(alpha = 0.3f),
                        CircleShape
                    )
            )
        }
        
        // Smaller inner circle for visual depth
        Box(
            modifier = Modifier
                .size(75.dp)
                .align(Alignment.CenterEnd)
                .offset(x = (-55).dp, y = 5.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        backgroundColor.copy(alpha = 0.6f),
                        CircleShape
                    )
            )
        }
        
        // Product image positioned to match Figma design
        Box(
            modifier = Modifier
                .size(imageSize)
                .align(Alignment.CenterEnd)
                .offset(x = (-1).dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(
                    when(title) {
                        "CLOTHING" -> Res.drawable.product_clothing
                        "ACCESSORIES" -> Res.drawable.product_accessories
                        "SHOES" -> if (backgroundColor == Color(0xFF44565C)) {
                            Res.drawable.product_shoes
                        } else {
                            Res.drawable.product_blazer
                        }
                        else -> Res.drawable.product_clothing
                    }
                ),
                contentDescription = imageDescription,
                modifier = Modifier
                    .size(imageSize)
                    .offset(x = (-1).dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}

@Composable
fun BottomTabBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color.White)
            .padding(horizontal = 54.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(Res.drawable.ic_home),
            contentDescription = "Home",
            tint = Color.Black,
            modifier = Modifier.size(23.dp)
        )

        Icon(
            painter = painterResource(Res.drawable.ic_search),
            contentDescription = "Cart",
            tint = Color.Black,
            modifier = Modifier.size(21.dp)
        )

        Icon(
            painter = painterResource(Res.drawable.ic_shopping_cart),
            contentDescription = "Cart",
            tint = Color.Black,
            modifier = Modifier.size(21.dp)
        )
        
        Icon(
            painter = painterResource(Res.drawable.ic_profile),
            contentDescription = "Profile",
            tint = Color.Black,
            modifier = Modifier.size(19.dp)
        )
    }
}