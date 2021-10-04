let search = function(){
    $(".item-view-hidden").hide();
      let value = $('#search-list').val().toLowerCase();
      $(".item-view-hidden").filter(function() {
       if ($(this).children(".item-name-search").text().toLowerCase().indexOf(value) > -1) {
            $(this).show();
          }
     });
};
