package com.example.mysootheapp

import android.content.res.Configuration
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mysootheapp.ui.theme.MySootheAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LargeTopAppBarExample()
         
        }
    }
}

@Composable
fun alignYourPreview(Img:Int,tag:String) {
         Column(
             modifier = Modifier.fillMaxWidth(),
             horizontalAlignment = Alignment.CenterHorizontally) {

             Image(painter = painterResource(Img),
                 contentDescription = null,
                 contentScale = ContentScale.Crop,
                 modifier = Modifier.clip(CircleShape)
                     .size(100.dp))
             Spacer(modifier = Modifier.size(5.dp))
             Text(text = tag,
                 fontSize = 10.sp)
             Spacer(modifier = Modifier.size(5.dp))
         }
}
@Preview(showBackground = true)
@Composable
fun Preview(){
     LazyRow(
         horizontalArrangement = Arrangement.spacedBy(10.dp),
         content = {
         items(getCategerylist()) { item ->
             alignYourPreview(Img = item.Img, tag = item.tag)
         }
     })
}

data class Categery(val Img: Int,val tag: String)

fun getCategerylist(): MutableList<Categery> {
    val list = mutableListOf<Categery>()
    list.add(Categery(R.drawable.divya,"Inversions"))
    list.add(Categery(R.drawable.divya,"Quick Yoga"))
    list.add(Categery(R.drawable.divya,"Stretching"))
    list.add(Categery(R.drawable.divya,"Tabata"))
    list.add(Categery(R.drawable.divya,"HIIT"))
    list.add(Categery(R.drawable.divya,"Pre-natal Yoga"))
    return list
}
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun AlignYourBody() {
   Column {
       Spacer(modifier = Modifier.size(10.dp))
       Text(text = "Align Your Body")
       Spacer(modifier = Modifier.size(12.dp))
       com.example.mysootheapp.Preview()
   }
}
@Composable
fun favoriteAppPreview(drawable: Int,text:String) {
 Surface(shape = MaterialTheme.shapes.medium,
     color = MaterialTheme.colorScheme.surfaceVariant) {
       Row(verticalAlignment = Alignment.CenterVertically,
           modifier = Modifier.width(255.dp)) {
           Image(painter = painterResource(drawable),
               contentDescription = null,
               contentScale = ContentScale.Crop,
               modifier = Modifier.size(80.dp))
           Text(text = text,
               modifier = Modifier.padding(horizontal = 16.dp))
       }
 }
}

data class Catagery2(val drawable: Int,val tag: String)

fun getCategrylist2(): MutableList<Catagery2> {
    val list2 = mutableListOf<Catagery2>()
    list2.add(Catagery2(R.drawable.divya,"Natural Maditation"))
    list2.add(Catagery2(R.drawable.divya,"Short Mantras"))

    list2.add(Catagery2(R.drawable.divya,"Overwahelmed"))
    list2.add(Catagery2(R.drawable.divya,"Stress and anxiety"))
    list2.add(Catagery2(R.drawable.divya,"Self massage"))
    list2.add(Catagery2(R.drawable.divya,"Nightly wind down"))
  return list2
}
@Preview(showBackground = true)
@Composable
fun favoriteAppCollection() {
LazyHorizontalGrid(
    rows = GridCells.Fixed(2),
    contentPadding = PaddingValues(horizontal = 16.dp),
    horizontalArrangement = Arrangement.spacedBy(8.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp),
    modifier = Modifier.height(168.dp)
) {
        items(getCategrylist2()) { item->
            favoriteAppPreview(item.drawable,item.tag)

        }
    }
    }

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun favorateAppCollectionPreview() {
    Column {

        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "Favorite Collection")
        Spacer(modifier = Modifier.size(15.dp))
        com.example.mysootheapp.favoriteAppCollection()
    }
}
@Preview
@Composable
fun BottomBarPreview() {
  NavigationBar(contentColor = MaterialTheme.colorScheme.surfaceVariant) {
        NavigationBarItem(
            icon = { Icon(imageVector = Icons.Default.Home,
                      contentDescription = null)
  },
            label = {
                Text(text = "Home")},
            selected = true,
            onClick = {}
        )
       NavigationBarItem(
           icon =  {Icon(imageVector = Icons.Default.Person,
               contentDescription = null) },
           label = { Text(text = "Profile") },
           selected = true,
           onClick = {}
       )
}
}
// TOPBAR,SEARCH BAR ,ALIGN YOUT BODY PREVIEW,
// FAVORITE COLLECTION PREVIEW,
// FLOATING ACTION BOTTON,BOTTOM BAR//
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun LargeTopAppBarExample() {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            MediumTopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),

                title = {
                    Text(
                        "My Soothe App",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Localized description"
                        )
                    }
                },
                scrollBehavior = scrollBehavior
            )
        },
     bottomBar = {
         BottomBarPreview()
     },
             floatingActionButton = {
         FloatingActionButton(onClick = {}) {
             Icon(Icons.Default.Add,
                 contentDescription = null)
         }
     }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            sootheApp()
        }
    }
}