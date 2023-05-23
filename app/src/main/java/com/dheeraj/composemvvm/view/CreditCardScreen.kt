import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dheeraj.composemvvm.viewmodel.CreditCardViewModel


@Composable
fun CreditCardScreen(viewModel: CreditCardViewModel) {
    val creditCards by viewModel.creditCards.observeAsState(null)

    LaunchedEffect(Unit) {
        viewModel.fetchCreditCards()
    }

    Column {
        if (creditCards == null) {
            // Show loading indicator or placeholder
            Text(text = "Loading...")
        } else {
            // Display the list of credit cards
            CreditCardItem(creditCards!!)
        }
    }
}


@Composable
fun CreditCardItem(creditCard: CreditCardResponse) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = creditCard.credit_card_number,
                style = MaterialTheme.typography.h6
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Expiry Date: ${creditCard.credit_card_expiry_date}",
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = creditCard.credit_card_type,
                style = MaterialTheme.typography.body1
            )
        }
    }
}
