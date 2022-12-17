package com.finalp.java

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.finalp.java.model.Contact
import com.finalp.java.ui.main.MainActivity
import com.finalp.java.ui.main.MainListItemViewModel
import org.junit.*
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class MainListItemViewModelTest {

    companion object {
        @ClassRule
        @JvmField
        val schedulers = RxImmediateSchedulerRule()

        @ClassRule
        @JvmField
        val ruleForLivaData = InstantTaskExecutorRule()
    }

    @Mock
    lateinit var mainActivity: MainActivity

    lateinit var mainListItemViewModel: MainListItemViewModel

    var contact = Contact()

    @Before
    fun setUp() {
        contact.firstName = "John"
        contact.lastName = "Doe"
        contact.age = 27
        contact.photo = "https://image.flaticon.com/icons/svg/145/145843.svg"

        MockitoAnnotations.initMocks(this)
        val controller = Robolectric.buildActivity(MainActivity::class.java).create().start().resume()
        mainActivity = controller.get()
        mainListItemViewModel = MainListItemViewModel(mainActivity)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainListItemViewModelBindTest() {
        mainListItemViewModel.bind(contact)

        Assert.assertEquals(contact, mainListItemViewModel.contact)
    }
}