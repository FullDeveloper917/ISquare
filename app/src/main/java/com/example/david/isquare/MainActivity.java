package com.example.david.isquare;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.david.isquare.Dialogs.UpdateDialog;
import com.example.david.isquare.Fragments.AdminFragments.AdminAllMembersFragment;
import com.example.david.isquare.Fragments.AdminFragments.AdminBanedMembersFragment;
import com.example.david.isquare.Fragments.AdminFragments.AdminDirectoriesFragments.AdminDirectoriesChoosePlaceFragment;
import com.example.david.isquare.Fragments.AdminFragments.AdminDirectoriesFragments.AdminDirectoriesChoosePhotoFragment;
import com.example.david.isquare.Fragments.AdminFragments.AdminDirectoriesFragments.AdminDirectoriesFragment;
import com.example.david.isquare.Fragments.AdminFragments.AdminShopsFragments.AdminShopsDesignChoosePhotoFragment;
import com.example.david.isquare.Fragments.AdminFragments.AdminShopsFragments.AdminShopsDesignChooseProductFragment;
import com.example.david.isquare.Fragments.AdminFragments.AdminShopsFragments.AdminShopsDesignFragment;
import com.example.david.isquare.Fragments.AdminFragments.AdminWithdrawalFragments.AdminWithdrawalDetailFragment;
import com.example.david.isquare.Fragments.AdminFragments.AdminWithdrawalFragments.AdminWithdrawalFragment;
import com.example.david.isquare.Fragments.AdminFragments.AdminFragment;
import com.example.david.isquare.Fragments.AdminFragments.AdminMomentsFragment;
import com.example.david.isquare.Fragments.AdminFragments.AdminPlacesFragment;
import com.example.david.isquare.Fragments.AdminFragments.AdminProductsFragment;
import com.example.david.isquare.Fragments.AdminFragments.AdminShopsFragment;
import com.example.david.isquare.Fragments.ChatsFragments.ChatSendContactsFragment;
import com.example.david.isquare.Fragments.ChatsFragments.ChatSendPhotoFragment;
import com.example.david.isquare.Fragments.ChatsFragments.ChatStaredItemFragment;
import com.example.david.isquare.Fragments.ChatsFragments.ChatStaredPlaceFragment;
import com.example.david.isquare.Fragments.ChatsFragments.ChatsFragment;
import com.example.david.isquare.Fragments.ChatsFragments.CreateGroupChatFragment;
import com.example.david.isquare.Fragments.ChatsFragments.GroupChatAddMembersFragment;
import com.example.david.isquare.Fragments.ChatsFragments.GroupChatFragment;
import com.example.david.isquare.Fragments.ChatsFragments.GroupChatMembersFragment;
import com.example.david.isquare.Fragments.ChatsFragments.GroupChatSettingsFragment;
import com.example.david.isquare.Fragments.ChatsFragments.ReportMessageFragment;
import com.example.david.isquare.Fragments.ChatsFragments.SingleChatFragment;
import com.example.david.isquare.Fragments.ChatsFragments.SingleChatSettingsFragment;
import com.example.david.isquare.Fragments.DirectoriesFragments.AddPlaceFragments.AddPlaceAddImageFragment;
import com.example.david.isquare.Fragments.DirectoriesFragments.AddPlaceFragments.AddPlaceFirstFragment;
import com.example.david.isquare.Fragments.DirectoriesFragments.EditPlaceFragments.EditPlaceAddImageFragment;
import com.example.david.isquare.Fragments.DirectoriesFragments.EditPlaceFragments.EditPlaceFragment;
import com.example.david.isquare.Fragments.DirectoriesFragments.MapFragment;
import com.example.david.isquare.Fragments.DirectoriesFragments.PlaceRequestSentFragment;
import com.example.david.isquare.Fragments.DirectoriesFragments.AddPlaceFragments.AddPlaceSecondFragment;
import com.example.david.isquare.Fragments.DirectoriesFragments.DirectoriesCategoryPlacesFragment;
import com.example.david.isquare.Fragments.DirectoriesFragments.DirectoriesFragment;
import com.example.david.isquare.Fragments.DirectoriesFragments.DirectoriesStaredPlacesFragment;
import com.example.david.isquare.Fragments.DirectoriesFragments.PlaceDetailsFragment;
import com.example.david.isquare.Fragments.DirectoriesFragments.PlaceLeaveReviewFragment;
import com.example.david.isquare.Fragments.DirectoriesFragments.PlaceMomentsFragment;
import com.example.david.isquare.Fragments.DirectoriesFragments.PlaceReviewsFragment;
import com.example.david.isquare.Fragments.MeFragments.AddressFragments.AddressFragment;
import com.example.david.isquare.Fragments.MeFragments.AddressFragments.EditAddressFragment;
import com.example.david.isquare.Fragments.MeFragments.AddressFragments.NewAddressFragment;
import com.example.david.isquare.Fragments.MeFragments.MyCartFragments.ChangeAddressFragment;
import com.example.david.isquare.Fragments.MeFragments.MyCartFragments.CheckOutFragment;
import com.example.david.isquare.Fragments.MeFragments.MyCartFragments.CheckOutProcessingFragment;
import com.example.david.isquare.Fragments.MeFragments.MyCartFragments.MyCartFragment;
import com.example.david.isquare.Fragments.MeFragments.MyContactsFragments.ContactGroupChatsFragment;
import com.example.david.isquare.Fragments.MeFragments.MyContactsFragments.ContactsFragment;
import com.example.david.isquare.Fragments.MeFragments.MyContactsFragments.FollowersFragment;
import com.example.david.isquare.Fragments.MeFragments.MyContactsFragments.ProfileFragment;
import com.example.david.isquare.Fragments.MeFragments.MyMomentsFragments.AddNewPhotoFragment;
import com.example.david.isquare.Fragments.MeFragments.MyMomentsFragments.AddNewTextFragment;
import com.example.david.isquare.Fragments.MeFragments.MyMomentsFragments.MyMomentsFragment;
import com.example.david.isquare.Fragments.MeFragments.MyOrdersFragments.MyOrderDetailOfOnTheWayFragment;
import com.example.david.isquare.Fragments.MeFragments.MyOrdersFragments.MyOrderDetailOfPickUpFragment;
import com.example.david.isquare.Fragments.MeFragments.MyOrdersFragments.MyOrderDetailOfProcessingFragment;
import com.example.david.isquare.Fragments.MeFragments.MyOrdersFragments.MyOrderDetailOfReceivedFragment;
import com.example.david.isquare.Fragments.MeFragments.MyOrdersFragments.MyOrderFirstReviewFragment;
import com.example.david.isquare.Fragments.MeFragments.MyOrdersFragments.MyOrderSecondReviewFragment;
import com.example.david.isquare.Fragments.MeFragments.MyOrdersFragments.MyOrderThanksFragment;
import com.example.david.isquare.Fragments.MeFragments.MyOrdersFragments.MyOrdersFragment;
import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.EditShopFragment;
import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.MyShopFragment;
import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.NewShopFragment;
import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.OrdersFragments.OrderDetailOfCanceledFragment;
import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.OrdersFragments.OrderDetailOfOnTheWayFragment;
import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.OrdersFragments.OrderDetailOfProcessingDeliveryFragment;
import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.OrdersFragments.OrderDetailOfProcessingPickUpFragment;
import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.OrdersFragments.OrderDetailOfReadyFragment;
import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.OrdersFragments.OrdersFragment;
import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.ProductsFragements.AddProductFragment;
import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.ProductsFragements.AddProductImageFragment;
import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.ProductsFragements.EditProductFragment;
import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.ProductsFragements.ProductsFragment;
import com.example.david.isquare.Fragments.MeFragments.MyShopFragments.ReviewsFragment;
import com.example.david.isquare.Fragments.MeFragments.MyWalletFragments.DepositFragment;
import com.example.david.isquare.Fragments.MeFragments.MyWalletFragments.MyWalletFragment;
import com.example.david.isquare.Fragments.MeFragments.MyWalletFragments.PaymentPasswordFragment;
import com.example.david.isquare.Fragments.MeFragments.MyWalletFragments.ProcessingFragment;
import com.example.david.isquare.Fragments.MeFragments.MyWalletFragments.TransactionsFragment;
import com.example.david.isquare.Fragments.MeFragments.MyWalletFragments.WithdrawalFragment;
import com.example.david.isquare.Fragments.MeFragments.NotificationsFragment;
import com.example.david.isquare.Fragments.MeFragments.SettingsFragments.ChangePasswordFragment;
import com.example.david.isquare.Fragments.MeFragments.SettingsFragments.DownloadUpdatesFragment;
import com.example.david.isquare.Fragments.MeFragments.SettingsFragments.MyQrCodeFragment;
import com.example.david.isquare.Fragments.MeFragments.SettingsFragments.PersonalDetailsFragment;
import com.example.david.isquare.Fragments.MeFragments.SettingsFragments.SettingsFragment;
import com.example.david.isquare.Fragments.MeFragments.SettingsFragments.TextSizeFragment;
import com.example.david.isquare.Fragments.MeFragments.SettingsFragments.UpdatesFragment;
import com.example.david.isquare.Fragments.MomentsFragments.CommentsFragment;
import com.example.david.isquare.Fragments.MomentsFragments.MomentsFragment;
import com.example.david.isquare.Fragments.MeFragments.MyPlacesFragment;
import com.example.david.isquare.Fragments.MomentsFragments.MomentsPartnerFragment;
import com.example.david.isquare.Fragments.ShopFragments.ShopDetailsNewFragment;
import com.example.david.isquare.Fragments.ShopFragments.ShopDetailsReviewFragment;
import com.example.david.isquare.Fragments.ShopFragments.ShopDetailsTwoHandFragment;
import com.example.david.isquare.Fragments.ShopFragments.ShopFragment;
import com.example.david.isquare.Fragments.MeFragments.UsersFragment;
import com.example.david.isquare.Fragments.ShopFragments.ShopMemberItemsFragment;
import com.example.david.isquare.Fragments.ShopFragments.ShopSearchFragment;
import com.example.david.isquare.Fragments.ShopFragments.StaredShopFragment;

public class MainActivity extends BaseActivity{
    private final static int ROTATION_ANIMATION_CYCLE = 3000;

    private Button btnUsers;
    private Button btnMoments;
    private Button btnShops;
    private Button btnChats;
    private Button btnDirectories;
    public LinearLayout layoutControlTab;

    public UsersFragment usersFragment;
    public MomentsFragment momentsFragment;
    public ChatsFragment chatsFragment;
    public MyPlacesFragment myPlacesFragment;
    public NewShopFragment newShopFragment;
    public MyShopFragment myShopFragment;
    public EditShopFragment editShopFragment;
    public ProductsFragment productsFragment;
    public AddProductFragment addProductFragment;
    public EditProductFragment editProductFragment;
    public AddProductImageFragment addProductImageFragment;
    public OrdersFragment ordersFragment;
    public OrderDetailOfProcessingDeliveryFragment orderDetailOfProcessingDeliveryFragment;
    public OrderDetailOfOnTheWayFragment orderDetailOfOnTheWayFragment;
    public OrderDetailOfReadyFragment orderDetailOfReadyFragment;
    public OrderDetailOfProcessingPickUpFragment orderDetailOfProcessingPickUpFragment;
    public OrderDetailOfCanceledFragment orderDetailOfCanceledFragment;
    public ReviewsFragment reviewsFragment;
    public MyMomentsFragment myMomentsFragment;
    public SettingsFragment settingsFragment;
    public PersonalDetailsFragment personalDetailsFragment;
    public MyQrCodeFragment myQrCodeFragment;
    public ChangePasswordFragment changePasswordFragment;
    public UpdatesFragment updatesFragment;
    public TextSizeFragment textSizeFragment;
    public DownloadUpdatesFragment downloadUpdatesFragment;
    public MyOrdersFragment myOrdersFragment;
    public MyOrderDetailOfProcessingFragment myOrderDetailOfProcessingFragment;
    public MyOrderDetailOfOnTheWayFragment myOrderDetailOfOnTheWayFragment;
    public MyOrderDetailOfPickUpFragment myOrderDetailOfPickUpFragment;
    public MyOrderDetailOfReceivedFragment myOrderDetailOfReceivedFragment;
    public AddressFragment addressFragment;
    public NewAddressFragment newAddressFragment;
    public EditAddressFragment editAddressFragment;
    public MyWalletFragment myWalletFragment;
    public WithdrawalFragment withdrawalFragment;
    public TransactionsFragment transactionsFragment;
    public DepositFragment depositFragment;
    public PaymentPasswordFragment paymentPasswordFragment;
    public ProcessingFragment processingFragment;
    public MyOrderFirstReviewFragment myOrderFirstReviewFragment;
    public MyOrderSecondReviewFragment myOrderSecondReviewFragment;
    public MyOrderThanksFragment myOrderThanksFragment;
    public MyCartFragment myCartFragment;
    public CheckOutFragment checkOutFragment;
    public CheckOutProcessingFragment checkOutProcessingFragment;
    public ChangeAddressFragment changeAddressFragment;
    public MomentsPartnerFragment momentsPartnerFragment;
    public AddNewPhotoFragment addNewPhotoFragment;
    public AddNewTextFragment addNewTextFragment;
    public NotificationsFragment notificationsFragment;
    public ContactsFragment contactsFragment;
    public FollowersFragment followersFragment;
    public ContactGroupChatsFragment contactGroupChatsFragment;
    public ProfileFragment profileFragment;
    public CommentsFragment commentsFragment;

    public ShopFragment shopFragment;
    public ShopSearchFragment shopSearchFragment;
    public StaredShopFragment staredShopFragment;
    public ShopDetailsNewFragment shopDetailsNewFragment;
    public ShopDetailsTwoHandFragment shopDetailsTwoHandFragment;
    public ShopDetailsReviewFragment shopDetailsReviewFragment;
    public ShopMemberItemsFragment shopMemberItemsFragment;

    public AdminFragment adminFragment;
    public AdminAllMembersFragment adminAllMembersFragment;
    public AdminBanedMembersFragment adminBanedMembersFragment;
    public AdminShopsFragment adminShopsFragment;
    public AdminProductsFragment adminProductsFragment;
    public AdminPlacesFragment adminPlacesFragment;
    public AdminMomentsFragment adminMomentsFragment;
    public AdminDirectoriesFragment adminDirectoriesFragment;
    public AdminDirectoriesChoosePlaceFragment adminDirectoriesChoosePlaceFragment;
    public AdminDirectoriesChoosePhotoFragment adminDirectoriesChoosePhotoFragment;
    public AdminWithdrawalFragment adminWithdrawalFragment;
    public AdminWithdrawalDetailFragment adminWithdrawalDetailFragment;
    public AdminShopsDesignFragment adminShopsDesignFragment;
    public AdminShopsDesignChoosePhotoFragment adminShopsDesignChoosePhotoFragment;
    public AdminShopsDesignChooseProductFragment adminShopsDesignChooseProductFragment;

    public SingleChatFragment singleChatFragment;
    public SingleChatSettingsFragment singleChatSettingsFragment;
    public GroupChatFragment groupChatFragment;
    public GroupChatSettingsFragment groupChatSettingsFragment;
    public GroupChatMembersFragment groupChatMembersFragment;
    public GroupChatAddMembersFragment groupChatAddMembersFragment;
    public CreateGroupChatFragment createGroupChatFragment;
    public ChatStaredPlaceFragment chatStaredPlaceFragment;
    public ChatStaredItemFragment chatStaredItemFragment;
    public ChatSendContactsFragment chatSendContactsFragment;
    public ChatSendPhotoFragment chatSendPhotoFragment;
    public ReportMessageFragment reportMessageFragment;

    public DirectoriesFragment directoriesFragment;
    public DirectoriesStaredPlacesFragment directoriesStaredPlacesFragment;
    public DirectoriesCategoryPlacesFragment directoriesCategoryPlacesFragment;
    public PlaceDetailsFragment placeDetailsFragment;
    public PlaceMomentsFragment placeMomentsFragment;
    public PlaceReviewsFragment placeReviewsFragment;
    public PlaceLeaveReviewFragment placeLeaveReviewFragment;
    public AddPlaceFirstFragment addPlaceFirstFragment;
    public AddPlaceSecondFragment addPlaceSecondFragment;
    public PlaceRequestSentFragment placeRequestSentFragment;
    public AddPlaceAddImageFragment addPlaceAddImageFragment;
    public EditPlaceFragment editPlaceFragment;
    public EditPlaceAddImageFragment editPlaceAddImageFragment;
    public MapFragment mapFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeObjects();
        findViews();
        setFormula();
        setEvents();
    }

    private void initializeObjects(){
        usersFragment = new UsersFragment();
        usersFragment.setMyActivity(this);
        momentsFragment = new MomentsFragment();
        momentsFragment.setMyActivity(this);
        chatsFragment = new ChatsFragment();
        chatsFragment.setMyActivity(this);
        myPlacesFragment = new MyPlacesFragment();
        myPlacesFragment.setMyActivity(this);
        newShopFragment = new NewShopFragment();
        newShopFragment.setMyActivity(this);
        myShopFragment = new MyShopFragment();
        myShopFragment.setMyActivity(this);
        editShopFragment = new EditShopFragment();
        editShopFragment.setMyActivity(this);
        productsFragment = new ProductsFragment();
        productsFragment.setMyActivity(this);
        addProductFragment = new AddProductFragment();
        addProductFragment.setMyActivity(this);
        editProductFragment = new EditProductFragment();
        editProductFragment.setMyActivity(this);
        addProductImageFragment = new AddProductImageFragment();
        addProductImageFragment.setMyActivity(this);
        ordersFragment = new OrdersFragment();
        ordersFragment.setMyActivity(this);
        orderDetailOfProcessingDeliveryFragment = new OrderDetailOfProcessingDeliveryFragment();
        orderDetailOfProcessingDeliveryFragment.setMyActivity(this);
        orderDetailOfOnTheWayFragment = new OrderDetailOfOnTheWayFragment();
        orderDetailOfOnTheWayFragment.setMyActivity(this);
        orderDetailOfReadyFragment = new OrderDetailOfReadyFragment();
        orderDetailOfReadyFragment.setMyActivity(this);
        orderDetailOfProcessingPickUpFragment = new OrderDetailOfProcessingPickUpFragment();
        orderDetailOfProcessingPickUpFragment.setMyActivity(this);
        orderDetailOfCanceledFragment = new OrderDetailOfCanceledFragment();
        orderDetailOfCanceledFragment.setMyActivity(this);
        reviewsFragment = new ReviewsFragment();
        reviewsFragment.setMyActivity(this);
        myMomentsFragment = new MyMomentsFragment();
        myMomentsFragment.setMyActivity(this);
        settingsFragment = new SettingsFragment();
        settingsFragment.setMyActivity(this);
        personalDetailsFragment = new PersonalDetailsFragment();
        personalDetailsFragment.setMyActivity(this);
        myQrCodeFragment = new MyQrCodeFragment();
        myQrCodeFragment.setMyActivity(this);
        changePasswordFragment = new ChangePasswordFragment();
        changePasswordFragment.setMyActivity(this);
        updatesFragment = new UpdatesFragment();
        updatesFragment.setMyActivity(this);
        textSizeFragment = new TextSizeFragment();
        textSizeFragment.setMyActivity(this);
        downloadUpdatesFragment = new DownloadUpdatesFragment();
        downloadUpdatesFragment.setMyActivity(this);
        myOrdersFragment = new MyOrdersFragment();
        myOrdersFragment.setMyActivity(this);
        myOrderDetailOfProcessingFragment = new MyOrderDetailOfProcessingFragment();
        myOrderDetailOfProcessingFragment.setMyActivity(this);
        myOrderDetailOfOnTheWayFragment = new MyOrderDetailOfOnTheWayFragment();
        myOrderDetailOfOnTheWayFragment.setMyActivity(this);
        myOrderDetailOfPickUpFragment = new MyOrderDetailOfPickUpFragment();
        myOrderDetailOfPickUpFragment.setMyActivity(this);
        myOrderDetailOfReceivedFragment = new MyOrderDetailOfReceivedFragment();
        myOrderDetailOfReceivedFragment.setMyActivity(this);
        addressFragment = new AddressFragment();
        addressFragment.setMyActivity(this);
        newAddressFragment = new NewAddressFragment();
        newAddressFragment.setMyActivity(this);
        editAddressFragment = new EditAddressFragment();
        editAddressFragment.setMyActivity(this);
        myWalletFragment = new MyWalletFragment();
        myWalletFragment.setMyActivity(this);
        withdrawalFragment = new WithdrawalFragment();
        withdrawalFragment.setMyActivity(this);
        transactionsFragment = new TransactionsFragment();
        transactionsFragment.setMyActivity(this);
        depositFragment = new DepositFragment();
        depositFragment.setMyActivity(this);
        paymentPasswordFragment = new PaymentPasswordFragment();
        paymentPasswordFragment.setMyActivity(this);
        processingFragment = new ProcessingFragment();
        processingFragment.setMyActivity(this);
        myOrderFirstReviewFragment = new MyOrderFirstReviewFragment();
        myOrderFirstReviewFragment.setMyActivity(this);
        myOrderSecondReviewFragment = new MyOrderSecondReviewFragment();
        myOrderSecondReviewFragment.setMyActivity(this);
        myOrderThanksFragment = new MyOrderThanksFragment();
        myOrderThanksFragment.setMyActivity(this);
        myCartFragment = new MyCartFragment();
        myCartFragment.setMyActivity(this);
        checkOutFragment = new CheckOutFragment();
        checkOutFragment.setMyActivity(this);
        checkOutProcessingFragment = new CheckOutProcessingFragment();
        checkOutProcessingFragment.setMyActivity(this);
        changeAddressFragment = new ChangeAddressFragment();
        changeAddressFragment.setMyActivity(this);
        momentsPartnerFragment = new MomentsPartnerFragment();
        momentsPartnerFragment.setMyActivity(this);
        addNewPhotoFragment = new AddNewPhotoFragment();
        addNewPhotoFragment.setMyActivity(this);
        addNewTextFragment = new AddNewTextFragment();
        addNewTextFragment.setMyActivity(this);
        notificationsFragment = new NotificationsFragment();
        notificationsFragment.setMyActivity(this);
        contactsFragment = new ContactsFragment();
        contactsFragment.setMyActivity(this);
        followersFragment = new FollowersFragment();
        followersFragment.setMyActivity(this);
        contactGroupChatsFragment = new ContactGroupChatsFragment();
        contactGroupChatsFragment.setMyActivity(this);
        profileFragment = new ProfileFragment();
        profileFragment.setMyActivity(this);
        commentsFragment = new CommentsFragment();
        commentsFragment.setMyActivity(this);

        shopFragment = new ShopFragment();
        shopFragment.setMyActivity(this);
        shopSearchFragment = new ShopSearchFragment();
        shopSearchFragment.setMyActivity(this);
        staredShopFragment = new StaredShopFragment();
        staredShopFragment.setMyActivity(this);
        shopDetailsNewFragment = new ShopDetailsNewFragment();
        shopDetailsNewFragment.setMyActivity(this);
        shopDetailsTwoHandFragment = new ShopDetailsTwoHandFragment();
        shopDetailsTwoHandFragment.setMyActivity(this);
        shopDetailsReviewFragment = new ShopDetailsReviewFragment();
        shopDetailsReviewFragment.setMyActivity(this);
        shopMemberItemsFragment = new ShopMemberItemsFragment();
        shopMemberItemsFragment.setMyActivity(this);
        adminFragment = new AdminFragment();
        adminFragment.setMyActivity(this);
        adminAllMembersFragment = new AdminAllMembersFragment();
        adminAllMembersFragment.setMyActivity(this);
        adminBanedMembersFragment = new AdminBanedMembersFragment();
        adminBanedMembersFragment.setMyActivity(this);
        adminShopsFragment = new AdminShopsFragment();
        adminShopsFragment.setMyActivity(this);
        adminProductsFragment = new AdminProductsFragment();
        adminProductsFragment.setMyActivity(this);
        adminPlacesFragment = new AdminPlacesFragment();
        adminPlacesFragment.setMyActivity(this);
        adminMomentsFragment = new AdminMomentsFragment();
        adminMomentsFragment.setMyActivity(this);
        adminDirectoriesFragment = new AdminDirectoriesFragment();
        adminDirectoriesFragment.setMyActivity(this);
        adminDirectoriesChoosePlaceFragment = new AdminDirectoriesChoosePlaceFragment();
        adminDirectoriesChoosePlaceFragment.setMyActivity(this);
        adminDirectoriesChoosePhotoFragment = new AdminDirectoriesChoosePhotoFragment();
        adminDirectoriesChoosePhotoFragment.setMyActivity(this);
        adminWithdrawalFragment = new AdminWithdrawalFragment();
        adminWithdrawalFragment.setMyActivity(this);
        adminWithdrawalDetailFragment = new AdminWithdrawalDetailFragment();
        adminWithdrawalDetailFragment.setMyActivity(this);
        adminShopsDesignFragment = new AdminShopsDesignFragment();
        adminShopsDesignFragment.setMyActivity(this);
        adminShopsDesignChoosePhotoFragment = new AdminShopsDesignChoosePhotoFragment();
        adminShopsDesignChoosePhotoFragment.setMyActivity(this);
        adminShopsDesignChooseProductFragment = new AdminShopsDesignChooseProductFragment();
        adminShopsDesignChooseProductFragment.setMyActivity(this);
        singleChatFragment = new SingleChatFragment();
        singleChatFragment.setMyActivity(this);
        singleChatSettingsFragment = new SingleChatSettingsFragment();
        singleChatSettingsFragment.setMyActivity(this);
        groupChatFragment = new GroupChatFragment();
        groupChatFragment.setMyActivity(this);
        groupChatSettingsFragment = new GroupChatSettingsFragment();
        groupChatSettingsFragment.setMyActivity(this);
        groupChatMembersFragment = new GroupChatMembersFragment();
        groupChatMembersFragment.setMyActivity(this);
        groupChatAddMembersFragment = new GroupChatAddMembersFragment();
        groupChatAddMembersFragment.setMyActivity(this);
        createGroupChatFragment = new CreateGroupChatFragment();
        createGroupChatFragment.setMyActivity(this);
        chatStaredPlaceFragment = new ChatStaredPlaceFragment();
        chatStaredPlaceFragment.setMyActivity(this);
        chatStaredItemFragment = new ChatStaredItemFragment();
        chatStaredItemFragment.setMyActivity(this);
        chatSendContactsFragment = new ChatSendContactsFragment();
        chatSendContactsFragment.setMyActivity(this);
        chatSendPhotoFragment = new ChatSendPhotoFragment();
        chatSendPhotoFragment.setMyActivity(this);
        reportMessageFragment = new ReportMessageFragment();
        reportMessageFragment.setMyActivity(this);

        directoriesFragment = new DirectoriesFragment();
        directoriesFragment.setMyActivity(this);
        directoriesStaredPlacesFragment = new DirectoriesStaredPlacesFragment();
        directoriesStaredPlacesFragment.setMyActivity(this);
        directoriesCategoryPlacesFragment = new DirectoriesCategoryPlacesFragment();
        directoriesCategoryPlacesFragment.setMyActivity(this);
        placeDetailsFragment = new PlaceDetailsFragment();
        placeDetailsFragment.setMyActivity(this);
        placeMomentsFragment = new PlaceMomentsFragment();
        placeMomentsFragment.setMyActivity(this);
        placeReviewsFragment = new PlaceReviewsFragment();
        placeReviewsFragment.setMyActivity(this);
        placeLeaveReviewFragment = new PlaceLeaveReviewFragment();
        placeLeaveReviewFragment.setMyActivity(this);
        addPlaceFirstFragment = new AddPlaceFirstFragment();
        addPlaceFirstFragment.setMyActivity(this);
        addPlaceSecondFragment = new AddPlaceSecondFragment();
        addPlaceSecondFragment.setMyActivity(this);
        placeRequestSentFragment = new PlaceRequestSentFragment();
        placeRequestSentFragment.setMyActivity(this);
        addPlaceAddImageFragment = new AddPlaceAddImageFragment();
        addPlaceAddImageFragment.setMyActivity(this);
        editPlaceFragment = new EditPlaceFragment();
        editPlaceFragment.setMyActivity(this);
        editPlaceAddImageFragment = new EditPlaceAddImageFragment();
        editPlaceAddImageFragment.setMyActivity(this);
        mapFragment = new MapFragment();
        mapFragment.setMyActivity(this);


        getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, usersFragment).commit();

        new UpdateDialog(this).show();
    }

    private void findViews(){
        btnUsers = (Button) findViewById(R.id.btnUsers_Main);
        btnMoments = (Button) findViewById(R.id.btnMoments_Main);
        btnShops = (Button) findViewById(R.id.btnShops_Main);
        btnChats = (Button) findViewById(R.id.btnChats_Main);
        btnDirectories = (Button) findViewById(R.id.btnDirectories_Main);
        layoutControlTab = (LinearLayout) findViewById(R.id.layoutControlTab_Main);
    }

    private void setFormula(){
        btnUsers.setTypeface(iconFont);
        btnMoments.setTypeface(iconFont);
        btnShops.setTypeface(iconFont);
        btnChats.setTypeface(iconFont);
        btnDirectories.setTypeface(iconFont);
    }

    private void setEvents(){
        btnUsers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, usersFragment).commit();
            }
        });

        btnMoments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, momentsFragment).commit();
            }
        });

        btnShops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, shopFragment).commit();
            }
        });

        btnChats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, chatsFragment).commit();
            }
        });

        btnDirectories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.frgMain, directoriesFragment).commit();
            }
        });
    }
}
