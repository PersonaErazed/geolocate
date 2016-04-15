# geolocate
Geolocation a list of times given a list of location-time coordinates. A piece of software to help me gps tag photos from a trip.

---
## Example: Appalachian Trail
### Preparing your data
The hike was started at [Springer Mount Georgia](http://www.openstreetmap.org/node/358771759) on April 1, 2015.

* From [openstreetmap.org](http://www.openstreetmap.org/#map=3/27.45/-21.62) we find Springer Mt. is located at 34.6273 degrees North of the [equator](https://en.wikipedia.org/wiki/Equator) and 84.1935 degrees West of [prime meridian](https://en.wikipedia.org/wiki/Prime_meridian).
* From the timestamp in the metadata of the first picture taken we find the hike started on April 1, 2015 at 8:04 AM Eastern Daylight Time.

The hike ended at [Mt. Katahdin Maine](http://www.openstreetmap.org/node/358226210)
* Again using [openstreetmap.org](http://www.openstreetmap.org/#map=3/27.45/-21.62) we find Mt. Katahdin is located at 45.9031 degrees North of the equator and 68.9190 degrees West of the prime meridian.
* From the timestamp of last hiking photo we find the hike end on October 12, 2015 at 4:02 PM Eastern Daylight Time.

We summerize this data in a table as follows using the International Organization for Standardization specifications for the format to represent Latitude-Longitude coordinates [ISO 6709](https://www.w3.org/2005/Incubator/geo/Wiki/LatitudeLongitudeAltitude.html) and the format to represent date and time [ISO 8601](https://www.w3.org/TR/NOTE-datetime).

| Coordinates | Date  |
| --- | --- |
| +34.6273-084.1935/ | 2015-04-01T08:04.20-05:00 |
| +45.9031-068.1935/ | 2015-10-12T16:02.55-05:00 |

_Remarks_
* The data in the table is what in the description is refered to as a _list of known location-time coordinates_.
* **There must be at least two known location-time coordinates** i.e. the beginning and end.
* More known coordinates will improve the accuracy of identifing the location of each photo. Note in this example two point yeilds a very resonable accuracy for a continuous thru hike.
* To improve accuracy consider added known points where time was spend off trail (start and stop), where/when you flipped, or etc.

**Now**, let us consider the photos we want to identify with a location.
We need a list of all the timestamps for the photos during the hike you wish to associate with a location.

| timestamp of photo |
|:---:|
| 2015-04-01T08:04.20-05:00 |
| 2015-04-01T08:04.32-05:00 |
| 2015-04-01T08:23.20-05:00 |
| 2015-04-01T10:14.24-05:00 |
| 2015-04-02T06:44.04-05:00 |
| . . . |
| 2015-10-12T16:02.55-05:00 |

After finishing this program I will write another program to create a list of timestamps given a list of files.

_Remarks_
* timestamps uniquely identify photos taken from the same camera, so it is not neccessary for this program to identify the photos name (or other atribute) with the timestamp.
* even if the photos are taken from multiple it is likely very few photos are likely to have the same timestamp done to the second.
