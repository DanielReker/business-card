package io.github.danielreker.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.danielreker.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(Modifier.background(BACKGROUND_COLOR)) {
                        BusinessCard(
                            modifier = Modifier
                                .padding(innerPadding)
                                .fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}

val MAIN_COLOR = Color(0xFF00ACC1)
val BACKGROUND_COLOR = Color(0x2700E5FF)
val ANDROID_LOGO_COLOR = Color(0xFF525252)

@Composable
fun BusinessCardHeader(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(Modifier.clip(RoundedCornerShape(32.dp))) {
            Image(
                painter = painterResource(R.drawable.android_logo),
                contentDescription = stringResource(R.string.android_logo_description),
                modifier = Modifier
                    .width(200.dp)
                    .background(ANDROID_LOGO_COLOR),
            )
        }
        Text(
            text = stringResource(R.string.full_name_text),
            fontSize = 36.sp,
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
        )
        Text(
            text = stringResource(R.string.title_text),
            color = MAIN_COLOR,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
@Preview(showBackground = true)
fun BusinessCardHeaderPreview() {
    BusinessCardTheme{
        BusinessCardHeader()
    }
}

@Composable
fun ContactInfoEntry(text: String, modifier: Modifier = Modifier, icon: @Composable () -> Unit) {
    Box(modifier) {
        Row(Modifier.padding(vertical = 4.dp)) {
            icon()
            Text(
                text = text,
                modifier = Modifier.padding(start = 24.dp),
            )
        }
    }
}

@Composable
fun ContactInfo(modifier: Modifier = Modifier) {
    Column(modifier) {
        ContactInfoEntry(text = stringResource(id = R.string.phone_number)) {
            Icon(
                Icons.Rounded.Phone,
                contentDescription = stringResource(id = R.string.phone_icon_description),
                tint = MAIN_COLOR,
            )
        }
        ContactInfoEntry(text = stringResource(id = R.string.social_media_handle)) {
            Icon(
                Icons.Rounded.Share,
                contentDescription = stringResource(id = R.string.share_icon_description),
                tint = MAIN_COLOR,
            )
        }
        ContactInfoEntry(text = stringResource(id = R.string.email)) {
            Icon(
                Icons.Rounded.Email,
                contentDescription = stringResource(id = R.string.email_icon_description),
                tint = MAIN_COLOR,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ContactInfoPreview() {
    BusinessCardTheme{
        ContactInfo()
    }
}


@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BusinessCardHeader(Modifier.padding(top = 200.dp))
        ContactInfo(Modifier.padding(bottom = 48.dp))
    }

}


@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard(Modifier.fillMaxSize().background(BACKGROUND_COLOR))
    }
}