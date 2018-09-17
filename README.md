# galleryapp

Main Components of the app:
MainActivity: Starting place of the application, which launches the aynscronus task (network layer), Fetch Images.
FetchImages: subclass of AsyncTask, which calls Flickr object.
Flickr: calls FlickrPhotos object to gather the images using the flickr api.
FlickrPhotos: contains elements of type FlickrPhoto, each of which hold relevant info of a particular image from Flickr.

FlickrPhotoAdapter: GridViews adapter, which populates the grid with the info from the PhotoInfo objects.
PhotoInfo: Compound view, which consists of a TextView to store text info of A FlickrPhoto and an ImageView to store a FlickrPhotos image.

Important Notes:
-To change the api query, go the FlickrPhotos class and manually change the tags parameter in the url.  Currently it retrieves photos
from Flickr based on tags=Toronto.

Future Improvements:
-Make an EditText and search button in main layout, to change the tags parameter in the query api.
-Encapsulate the api_key within FlickrPhotos class
